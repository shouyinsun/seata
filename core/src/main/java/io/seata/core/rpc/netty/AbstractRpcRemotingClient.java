/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.core.rpc.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;
import io.seata.common.exception.FrameworkErrorCode;
import io.seata.common.exception.FrameworkException;
import io.seata.common.thread.NamedThreadFactory;
import io.seata.common.util.NetUtil;
import io.seata.core.protocol.*;
import io.seata.core.rpc.ClientMessageListener;
import io.seata.core.rpc.ClientMessageSender;
import io.seata.discovery.loadbalance.LoadBalanceFactory;
import io.seata.discovery.registry.RegistryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

import static io.seata.common.exception.FrameworkErrorCode.NoAvailableService;

/**
 * The type Rpc remoting client.
 *
 * @author slievrly
 * @author zhaojun
 */
//远程rpc client
public abstract class AbstractRpcRemotingClient extends AbstractRpcRemoting
    implements RegisterMsgListener, ClientMessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRpcRemotingClient.class);
    private static final String MSG_ID_PREFIX = "msgId:";
    private static final String FUTURES_PREFIX = "futures:";
    private static final String SINGLE_LOG_POSTFIX = ";";
    private static final int MAX_MERGE_SEND_MILLS = 1;
    private static final String THREAD_PREFIX_SPLIT_CHAR = "_";

    private static final int MAX_MERGE_SEND_THREAD = 1;
    private static final long KEEP_ALIVE_TIME = Integer.MAX_VALUE;
    private static final int SCHEDULE_INTERVAL_MILLS = 5;
    private static final String MERGE_THREAD_PREFIX = "rpcMergeMessageSend";

    private final RpcClientBootstrap clientBootstrap;
    private NettyClientChannelManager clientChannelManager;
    //client message 监听
    private ClientMessageListener clientMessageListener;
    //角色
    private final NettyPoolKey.TransactionRole transactionRole;
    //merge 发送线程池
    private ExecutorService mergeSendExecutorService;

    public AbstractRpcRemotingClient(NettyClientConfig nettyClientConfig, EventExecutorGroup eventExecutorGroup,
                                     ThreadPoolExecutor messageExecutor, NettyPoolKey.TransactionRole transactionRole) {
        super(messageExecutor);
        this.transactionRole = transactionRole;
        clientBootstrap = new RpcClientBootstrap(nettyClientConfig, eventExecutorGroup, this, transactionRole);
        //client channel 管理
        clientChannelManager = new NettyClientChannelManager(
            new NettyPoolableFactory(this, clientBootstrap), getPoolKeyFunction(), nettyClientConfig);
    }

    public NettyClientChannelManager getClientChannelManager() {
        return clientChannelManager;
    }

    /**
     * Get pool key function.
     *
     * @return lambda function
     */
    protected abstract Function<String, NettyPoolKey> getPoolKeyFunction();

    /**
     * Get transaction service group.
     *
     * @return transaction service group
     */
    protected abstract String getTransactionServiceGroup();

    @Override
    public void init() {
        //start netty client
        clientBootstrap.start();
        //5s,reconnect to server
        timerExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                clientChannelManager.reconnect(getTransactionServiceGroup());
            }
        }, SCHEDULE_INTERVAL_MILLS, SCHEDULE_INTERVAL_MILLS, TimeUnit.SECONDS);
        if (NettyClientConfig.isEnableClientBatchSendRequest()) {//可以批量发送
            //merge 发送线程池 固定线程数1
            mergeSendExecutorService = new ThreadPoolExecutor(MAX_MERGE_SEND_THREAD,
                MAX_MERGE_SEND_THREAD,
                KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory(getThreadPrefix(), MAX_MERGE_SEND_THREAD));
            mergeSendExecutorService.submit(new MergedSendRunnable());
        }
        super.init();
    }

    @Override
    public void destroy() {
        clientBootstrap.shutdown();
        if (mergeSendExecutorService != null) {
            mergeSendExecutorService.shutdown();
        }
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!(msg instanceof RpcMessage)) {
            return;
        }
        RpcMessage rpcMessage = (RpcMessage) msg;
        if (rpcMessage.getBody() == HeartbeatMessage.PONG) {//pong message
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("received PONG from {}", ctx.channel().remoteAddress());
            }
            return;
        }
        if (rpcMessage.getBody() instanceof MergeResultMessage) {//mergeResult
            MergeResultMessage results = (MergeResultMessage) rpcMessage.getBody();
            MergedWarpMessage mergeMessage = (MergedWarpMessage) mergeMsgMap.remove(rpcMessage.getId());
            for (int i = 0; i < mergeMessage.msgs.size(); i++) {
                int msgId = mergeMessage.msgIds.get(i);
                MessageFuture future = futures.remove(msgId);
                if (future == null) {
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.info("msg: {} is not found in futures.", msgId);
                    }
                } else {
                    future.setResultMessage(results.getMsgs()[i]);
                }
            }
            return;
        }
        super.channelRead(ctx, msg);
    }

    @Override
    public void dispatch(RpcMessage request, ChannelHandlerContext ctx) {//分发请求
        if (clientMessageListener != null) {
            String remoteAddress = NetUtil.toStringAddress(ctx.channel().remoteAddress());
            //触发监听
            clientMessageListener.onMessage(request, remoteAddress, this);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        if (messageExecutor.isShutdown()) {
            return;
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("channel inactive: {}", ctx.channel());
        }
        clientChannelManager.releaseChannel(ctx.channel(), NetUtil.toStringAddress(ctx.channel().remoteAddress()));
        super.channelInactive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {//闲置时间
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {//读闲置
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("channel {} read idle.", ctx.channel());
                }
                try {
                    String serverAddress = NetUtil.toStringAddress(ctx.channel().remoteAddress());
                    clientChannelManager.invalidateObject(serverAddress, ctx.channel());
                } catch (Exception exx) {
                    LOGGER.error(exx.getMessage());
                } finally {
                    //释放channel
                    clientChannelManager.releaseChannel(ctx.channel(), getAddressFromContext(ctx));
                }
            }
            //写闲置
            if (idleStateEvent == IdleStateEvent.WRITER_IDLE_STATE_EVENT) {
                try {
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("will send ping msg,channel {}", ctx.channel());
                    }
                    //发送心跳
                    sendRequest(ctx.channel(), HeartbeatMessage.PING);
                } catch (Throwable throwable) {
                    LOGGER.error("send request error: {}", throwable.getMessage(), throwable);
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error(FrameworkErrorCode.ExceptionCaught.getErrCode(),
            NetUtil.toStringAddress(ctx.channel().remoteAddress()) + "connect exception. " + cause.getMessage(), cause);
        clientChannelManager.releaseChannel(ctx.channel(), getAddressFromChannel(ctx.channel()));
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("remove exception rm channel:{}", ctx.channel());
        }
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public Object sendMsgWithResponse(Object msg, long timeout) throws TimeoutException {
        //loadBalance
        String validAddress = loadBalance(getTransactionServiceGroup());
        Channel channel = clientChannelManager.acquireChannel(validAddress);
        Object result = super.sendAsyncRequestWithResponse(validAddress, channel, msg, timeout);
        return result;
    }

    @Override
    public Object sendMsgWithResponse(Object msg) throws TimeoutException {
        return sendMsgWithResponse(msg, NettyClientConfig.getRpcRequestTimeout());
    }

    @Override
    public Object sendMsgWithResponse(String serverAddress, Object msg, long timeout)
        throws TimeoutException {
        return sendAsyncRequestWithResponse(serverAddress, clientChannelManager.acquireChannel(serverAddress), msg, timeout);
    }

    @Override
    public void sendResponse(RpcMessage request, String serverAddress, Object msg) {
        super.sendResponse(request, clientChannelManager.acquireChannel(serverAddress), msg);
    }

    /**
     * Gets client message listener.
     *
     * @return the client message listener
     */
    public ClientMessageListener getClientMessageListener() {
        return clientMessageListener;
    }

    /**
     * Sets client message listener.
     *
     * @param clientMessageListener the client message listener
     */
    public void setClientMessageListener(ClientMessageListener clientMessageListener) {
        this.clientMessageListener = clientMessageListener;
    }

    @Override
    public void destroyChannel(String serverAddress, Channel channel) {
        clientChannelManager.destroyChannel(serverAddress, channel);
    }

    private String loadBalance(String transactionServiceGroup) {
        InetSocketAddress address = null;
        try {
            List<InetSocketAddress> inetSocketAddressList = RegistryFactory.getInstance().lookup(transactionServiceGroup);
            address = LoadBalanceFactory.getInstance().select(inetSocketAddressList);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
        if (address == null) {
            throw new FrameworkException(NoAvailableService);
        }
        return NetUtil.toStringAddress(address);
    }

    private String getThreadPrefix() {
        return AbstractRpcRemotingClient.MERGE_THREAD_PREFIX + THREAD_PREFIX_SPLIT_CHAR + transactionRole.name();
    }

    /**
     * The type Merged send runnable.
     */
    //merge 发送线程
    private class MergedSendRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (mergeLock) {
                    try {
                        //处理间隔时间
                        mergeLock.wait(MAX_MERGE_SEND_MILLS);
                    } catch (InterruptedException e) {
                    }
                }
                isSending = true;
                for (String address : basketMap.keySet()) {
                    BlockingQueue<RpcMessage> basket = basketMap.get(address);
                    if (basket.isEmpty()) {
                        continue;
                    }

                    MergedWarpMessage mergeMessage = new MergedWarpMessage();
                    //merge message
                    while (!basket.isEmpty()) {
                        RpcMessage msg = basket.poll();
                        mergeMessage.msgs.add((AbstractMessage) msg.getBody());
                        mergeMessage.msgIds.add(msg.getId());
                    }
                    if (mergeMessage.msgIds.size() > 1) {
                        printMergeMessageLog(mergeMessage);
                    }
                    Channel sendChannel = null;
                    try {
                        sendChannel = clientChannelManager.acquireChannel(address);
                        sendRequest(sendChannel, mergeMessage);
                    } catch (FrameworkException e) {
                        if (e.getErrcode() == FrameworkErrorCode.ChannelIsNotWritable && sendChannel != null) {
                            destroyChannel(address, sendChannel);
                        }
                        // fast fail
                        for (Integer msgId : mergeMessage.msgIds) {
                            MessageFuture messageFuture = futures.remove(msgId);
                            if (messageFuture != null) {
                                messageFuture.setResultMessage(null);
                            }
                        }
                        LOGGER.error("client merge call failed: {}", e.getMessage(), e);
                    }
                }
                isSending = false;
            }
        }

        private void printMergeMessageLog(MergedWarpMessage mergeMessage) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("merge msg size:{}", mergeMessage.msgIds.size());
                for (AbstractMessage cm : mergeMessage.msgs) {
                    LOGGER.debug(cm.toString());
                }
                StringBuilder sb = new StringBuilder();
                for (long l : mergeMessage.msgIds) {
                    sb.append(MSG_ID_PREFIX).append(l).append(SINGLE_LOG_POSTFIX);
                }
                sb.append("\n");
                for (long l : futures.keySet()) {
                    sb.append(FUTURES_PREFIX).append(l).append(SINGLE_LOG_POSTFIX);
                }
                LOGGER.debug(sb.toString());
            }
        }
    }
}
