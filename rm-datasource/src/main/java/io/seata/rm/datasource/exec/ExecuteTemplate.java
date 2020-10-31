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
package io.seata.rm.datasource.exec;

import io.seata.core.context.RootContext;
import io.seata.rm.datasource.StatementProxy;
import io.seata.rm.datasource.sql.SQLVisitorFactory;
import io.seata.sqlparser.SQLRecognizer;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * The type Execute template.
 *
 * @author sharajava
 */
public class ExecuteTemplate {//执行模板

    /**
     * Execute t.
     *
     * @param <T>               the type parameter
     * @param <S>               the type parameter
     * @param statementProxy    the statement proxy
     * @param statementCallback the statement callback
     * @param args              the args
     * @return the t
     * @throws SQLException the sql exception
     */
    public static <T, S extends Statement> T execute(StatementProxy<S> statementProxy,
                                                     StatementCallback<T, S> statementCallback,
                                                     Object... args) throws SQLException {
        return execute(null, statementProxy, statementCallback, args);
    }

    /**
     * Execute t.
     *
     * @param <T>               the type parameter
     * @param <S>               the type parameter
     * @param sqlRecognizer     the sql recognizer
     * @param statementProxy    the statement proxy
     * @param statementCallback the statement callback
     * @param args              the args
     * @return the t
     * @throws SQLException the sql exception
     */
    public static <T, S extends Statement> T execute(SQLRecognizer sqlRecognizer,
                                                     StatementProxy<S> statementProxy,
                                                     StatementCallback<T, S> statementCallback,
                                                     Object... args) throws SQLException {

        //不在全局事务并且不要求全局锁
        if (!RootContext.inGlobalTransaction() && !RootContext.requireGlobalLock()) {
            // Just work as original statement
            // 执行源语句
            return statementCallback.execute(statementProxy.getTargetStatement(), args);
        }

        if (sqlRecognizer == null) {//sql识别器
            sqlRecognizer = SQLVisitorFactory.get(
                    statementProxy.getTargetSQL(),
                    statementProxy.getConnectionProxy().getDbType());
        }
        Executor<T> executor;
        if (sqlRecognizer == null) {
            executor = new PlainExecutor<>(statementProxy, statementCallback);
        } else {
            //根据sql类型,生成executor执行器
            switch (sqlRecognizer.getSQLType()) {
                case INSERT:
                    executor = new InsertExecutor<>(statementProxy, statementCallback, sqlRecognizer);
                    break;
                case UPDATE:
                    executor = new UpdateExecutor<>(statementProxy, statementCallback, sqlRecognizer);
                    break;
                case DELETE:
                    executor = new DeleteExecutor<>(statementProxy, statementCallback, sqlRecognizer);
                    break;
                case SELECT_FOR_UPDATE:
                    executor = new SelectForUpdateExecutor<>(statementProxy, statementCallback, sqlRecognizer);
                    break;
                default:
                    executor = new PlainExecutor<>(statementProxy, statementCallback);
                    break;
            }
        }
        T rs;
        try {
            rs = executor.execute(args);
        } catch (Throwable ex) {
            if (!(ex instanceof SQLException)) {
                // Turn other exception into SQLException
                ex = new SQLException(ex);
            }
            throw (SQLException)ex;
        }
        return rs;
    }
}
