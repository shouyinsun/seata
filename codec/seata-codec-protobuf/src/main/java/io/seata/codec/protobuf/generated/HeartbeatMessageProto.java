// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: heartbeatMessage.proto

package io.seata.codec.protobuf.generated;

/**
 * <pre>
 * PublishRequest is a publish request.
 * </pre>
 *
 * Protobuf type {@code io.seata.protocol.protobuf.HeartbeatMessageProto}
 */
public  final class HeartbeatMessageProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.seata.protocol.protobuf.HeartbeatMessageProto)
    HeartbeatMessageProtoOrBuilder {
  // Use HeartbeatMessageProto.newBuilder() to construct.
  private HeartbeatMessageProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HeartbeatMessageProto() {
    ping_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private HeartbeatMessageProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            ping_ = input.readBool();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.seata.codec.protobuf.generated.HeartbeatMessage.internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.seata.codec.protobuf.generated.HeartbeatMessage.internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.seata.codec.protobuf.generated.HeartbeatMessageProto.class, io.seata.codec.protobuf.generated.HeartbeatMessageProto.Builder.class);
  }

  public static final int PING_FIELD_NUMBER = 1;
  private boolean ping_;
  /**
   * <code>bool ping = 1;</code>
   */
  public boolean getPing() {
    return ping_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (ping_ != false) {
      output.writeBool(1, ping_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (ping_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, ping_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.seata.codec.protobuf.generated.HeartbeatMessageProto)) {
      return super.equals(obj);
    }
    io.seata.codec.protobuf.generated.HeartbeatMessageProto other = (io.seata.codec.protobuf.generated.HeartbeatMessageProto) obj;

    boolean result = true;
    result = result && (getPing()
        == other.getPing());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getPing());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.seata.codec.protobuf.generated.HeartbeatMessageProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * PublishRequest is a publish request.
   * </pre>
   *
   * Protobuf type {@code io.seata.protocol.protobuf.HeartbeatMessageProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.seata.protocol.protobuf.HeartbeatMessageProto)
      io.seata.codec.protobuf.generated.HeartbeatMessageProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.seata.codec.protobuf.generated.HeartbeatMessage.internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.seata.codec.protobuf.generated.HeartbeatMessage.internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.seata.codec.protobuf.generated.HeartbeatMessageProto.class, io.seata.codec.protobuf.generated.HeartbeatMessageProto.Builder.class);
    }

    // Construct using io.seata.codec.protobuf.generated.HeartbeatMessageProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      ping_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.seata.codec.protobuf.generated.HeartbeatMessage.internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_descriptor;
    }

    public io.seata.codec.protobuf.generated.HeartbeatMessageProto getDefaultInstanceForType() {
      return io.seata.codec.protobuf.generated.HeartbeatMessageProto.getDefaultInstance();
    }

    public io.seata.codec.protobuf.generated.HeartbeatMessageProto build() {
      io.seata.codec.protobuf.generated.HeartbeatMessageProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.seata.codec.protobuf.generated.HeartbeatMessageProto buildPartial() {
      io.seata.codec.protobuf.generated.HeartbeatMessageProto result = new io.seata.codec.protobuf.generated.HeartbeatMessageProto(this);
      result.ping_ = ping_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.seata.codec.protobuf.generated.HeartbeatMessageProto) {
        return mergeFrom((io.seata.codec.protobuf.generated.HeartbeatMessageProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.seata.codec.protobuf.generated.HeartbeatMessageProto other) {
      if (other == io.seata.codec.protobuf.generated.HeartbeatMessageProto.getDefaultInstance()) return this;
      if (other.getPing() != false) {
        setPing(other.getPing());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.seata.codec.protobuf.generated.HeartbeatMessageProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.seata.codec.protobuf.generated.HeartbeatMessageProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean ping_ ;
    /**
     * <code>bool ping = 1;</code>
     */
    public boolean getPing() {
      return ping_;
    }
    /**
     * <code>bool ping = 1;</code>
     */
    public Builder setPing(boolean value) {
      
      ping_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool ping = 1;</code>
     */
    public Builder clearPing() {
      
      ping_ = false;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:io.seata.protocol.protobuf.HeartbeatMessageProto)
  }

  // @@protoc_insertion_point(class_scope:io.seata.protocol.protobuf.HeartbeatMessageProto)
  private static final io.seata.codec.protobuf.generated.HeartbeatMessageProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.seata.codec.protobuf.generated.HeartbeatMessageProto();
  }

  public static io.seata.codec.protobuf.generated.HeartbeatMessageProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HeartbeatMessageProto>
      PARSER = new com.google.protobuf.AbstractParser<HeartbeatMessageProto>() {
    public HeartbeatMessageProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new HeartbeatMessageProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HeartbeatMessageProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HeartbeatMessageProto> getParserForType() {
    return PARSER;
  }

  public io.seata.codec.protobuf.generated.HeartbeatMessageProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

