// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: globalReportRequest.proto

package io.seata.codec.protobuf.generated;

/**
 * Protobuf type {@code io.seata.protocol.protobuf.GlobalReportRequestProto}
 */
public  final class GlobalReportRequestProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.seata.protocol.protobuf.GlobalReportRequestProto)
    GlobalReportRequestProtoOrBuilder {
  // Use GlobalReportRequestProto.newBuilder() to construct.
  private GlobalReportRequestProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GlobalReportRequestProto() {
    globalStatus_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GlobalReportRequestProto(
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
          case 10: {
            io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.Builder subBuilder = null;
            if (abstractGlobalEndRequest_ != null) {
              subBuilder = abstractGlobalEndRequest_.toBuilder();
            }
            abstractGlobalEndRequest_ = input.readMessage(io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(abstractGlobalEndRequest_);
              abstractGlobalEndRequest_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            globalStatus_ = rawValue;
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
    return io.seata.codec.protobuf.generated.GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.seata.codec.protobuf.generated.GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.seata.codec.protobuf.generated.GlobalReportRequestProto.class, io.seata.codec.protobuf.generated.GlobalReportRequestProto.Builder.class);
  }

  public static final int ABSTRACTGLOBALENDREQUEST_FIELD_NUMBER = 1;
  private io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto abstractGlobalEndRequest_;
  /**
   * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
   */
  public boolean hasAbstractGlobalEndRequest() {
    return abstractGlobalEndRequest_ != null;
  }
  /**
   * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
   */
  public io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto getAbstractGlobalEndRequest() {
    return abstractGlobalEndRequest_ == null ? io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.getDefaultInstance() : abstractGlobalEndRequest_;
  }
  /**
   * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
   */
  public io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProtoOrBuilder getAbstractGlobalEndRequestOrBuilder() {
    return getAbstractGlobalEndRequest();
  }

  public static final int GLOBALSTATUS_FIELD_NUMBER = 2;
  private int globalStatus_;
  /**
   * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
   */
  public int getGlobalStatusValue() {
    return globalStatus_;
  }
  /**
   * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
   */
  public io.seata.codec.protobuf.generated.GlobalStatusProto getGlobalStatus() {
    io.seata.codec.protobuf.generated.GlobalStatusProto result = io.seata.codec.protobuf.generated.GlobalStatusProto.valueOf(globalStatus_);
    return result == null ? io.seata.codec.protobuf.generated.GlobalStatusProto.UNRECOGNIZED : result;
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
    if (abstractGlobalEndRequest_ != null) {
      output.writeMessage(1, getAbstractGlobalEndRequest());
    }
    if (globalStatus_ != io.seata.codec.protobuf.generated.GlobalStatusProto.UnKnown.getNumber()) {
      output.writeEnum(2, globalStatus_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (abstractGlobalEndRequest_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAbstractGlobalEndRequest());
    }
    if (globalStatus_ != io.seata.codec.protobuf.generated.GlobalStatusProto.UnKnown.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, globalStatus_);
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
    if (!(obj instanceof io.seata.codec.protobuf.generated.GlobalReportRequestProto)) {
      return super.equals(obj);
    }
    io.seata.codec.protobuf.generated.GlobalReportRequestProto other = (io.seata.codec.protobuf.generated.GlobalReportRequestProto) obj;

    boolean result = true;
    result = result && (hasAbstractGlobalEndRequest() == other.hasAbstractGlobalEndRequest());
    if (hasAbstractGlobalEndRequest()) {
      result = result && getAbstractGlobalEndRequest()
          .equals(other.getAbstractGlobalEndRequest());
    }
    result = result && globalStatus_ == other.globalStatus_;
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasAbstractGlobalEndRequest()) {
      hash = (37 * hash) + ABSTRACTGLOBALENDREQUEST_FIELD_NUMBER;
      hash = (53 * hash) + getAbstractGlobalEndRequest().hashCode();
    }
    hash = (37 * hash) + GLOBALSTATUS_FIELD_NUMBER;
    hash = (53 * hash) + globalStatus_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto parseFrom(
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
  public static Builder newBuilder(io.seata.codec.protobuf.generated.GlobalReportRequestProto prototype) {
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
   * Protobuf type {@code io.seata.protocol.protobuf.GlobalReportRequestProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.seata.protocol.protobuf.GlobalReportRequestProto)
      io.seata.codec.protobuf.generated.GlobalReportRequestProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.seata.codec.protobuf.generated.GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.seata.codec.protobuf.generated.GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.seata.codec.protobuf.generated.GlobalReportRequestProto.class, io.seata.codec.protobuf.generated.GlobalReportRequestProto.Builder.class);
    }

    // Construct using io.seata.codec.protobuf.generated.GlobalReportRequestProto.newBuilder()
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
      if (abstractGlobalEndRequestBuilder_ == null) {
        abstractGlobalEndRequest_ = null;
      } else {
        abstractGlobalEndRequest_ = null;
        abstractGlobalEndRequestBuilder_ = null;
      }
      globalStatus_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.seata.codec.protobuf.generated.GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_descriptor;
    }

    public io.seata.codec.protobuf.generated.GlobalReportRequestProto getDefaultInstanceForType() {
      return io.seata.codec.protobuf.generated.GlobalReportRequestProto.getDefaultInstance();
    }

    public io.seata.codec.protobuf.generated.GlobalReportRequestProto build() {
      io.seata.codec.protobuf.generated.GlobalReportRequestProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.seata.codec.protobuf.generated.GlobalReportRequestProto buildPartial() {
      io.seata.codec.protobuf.generated.GlobalReportRequestProto result = new io.seata.codec.protobuf.generated.GlobalReportRequestProto(this);
      if (abstractGlobalEndRequestBuilder_ == null) {
        result.abstractGlobalEndRequest_ = abstractGlobalEndRequest_;
      } else {
        result.abstractGlobalEndRequest_ = abstractGlobalEndRequestBuilder_.build();
      }
      result.globalStatus_ = globalStatus_;
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
      if (other instanceof io.seata.codec.protobuf.generated.GlobalReportRequestProto) {
        return mergeFrom((io.seata.codec.protobuf.generated.GlobalReportRequestProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.seata.codec.protobuf.generated.GlobalReportRequestProto other) {
      if (other == io.seata.codec.protobuf.generated.GlobalReportRequestProto.getDefaultInstance()) return this;
      if (other.hasAbstractGlobalEndRequest()) {
        mergeAbstractGlobalEndRequest(other.getAbstractGlobalEndRequest());
      }
      if (other.globalStatus_ != 0) {
        setGlobalStatusValue(other.getGlobalStatusValue());
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
      io.seata.codec.protobuf.generated.GlobalReportRequestProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.seata.codec.protobuf.generated.GlobalReportRequestProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto abstractGlobalEndRequest_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto, io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.Builder, io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProtoOrBuilder> abstractGlobalEndRequestBuilder_;
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public boolean hasAbstractGlobalEndRequest() {
      return abstractGlobalEndRequestBuilder_ != null || abstractGlobalEndRequest_ != null;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto getAbstractGlobalEndRequest() {
      if (abstractGlobalEndRequestBuilder_ == null) {
        return abstractGlobalEndRequest_ == null ? io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.getDefaultInstance() : abstractGlobalEndRequest_;
      } else {
        return abstractGlobalEndRequestBuilder_.getMessage();
      }
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public Builder setAbstractGlobalEndRequest(io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto value) {
      if (abstractGlobalEndRequestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        abstractGlobalEndRequest_ = value;
        onChanged();
      } else {
        abstractGlobalEndRequestBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public Builder setAbstractGlobalEndRequest(
        io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.Builder builderForValue) {
      if (abstractGlobalEndRequestBuilder_ == null) {
        abstractGlobalEndRequest_ = builderForValue.build();
        onChanged();
      } else {
        abstractGlobalEndRequestBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public Builder mergeAbstractGlobalEndRequest(io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto value) {
      if (abstractGlobalEndRequestBuilder_ == null) {
        if (abstractGlobalEndRequest_ != null) {
          abstractGlobalEndRequest_ =
            io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.newBuilder(abstractGlobalEndRequest_).mergeFrom(value).buildPartial();
        } else {
          abstractGlobalEndRequest_ = value;
        }
        onChanged();
      } else {
        abstractGlobalEndRequestBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public Builder clearAbstractGlobalEndRequest() {
      if (abstractGlobalEndRequestBuilder_ == null) {
        abstractGlobalEndRequest_ = null;
        onChanged();
      } else {
        abstractGlobalEndRequest_ = null;
        abstractGlobalEndRequestBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.Builder getAbstractGlobalEndRequestBuilder() {
      
      onChanged();
      return getAbstractGlobalEndRequestFieldBuilder().getBuilder();
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProtoOrBuilder getAbstractGlobalEndRequestOrBuilder() {
      if (abstractGlobalEndRequestBuilder_ != null) {
        return abstractGlobalEndRequestBuilder_.getMessageOrBuilder();
      } else {
        return abstractGlobalEndRequest_ == null ?
            io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.getDefaultInstance() : abstractGlobalEndRequest_;
      }
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto, io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.Builder, io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProtoOrBuilder> 
        getAbstractGlobalEndRequestFieldBuilder() {
      if (abstractGlobalEndRequestBuilder_ == null) {
        abstractGlobalEndRequestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto, io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProto.Builder, io.seata.codec.protobuf.generated.AbstractGlobalEndRequestProtoOrBuilder>(
                getAbstractGlobalEndRequest(),
                getParentForChildren(),
                isClean());
        abstractGlobalEndRequest_ = null;
      }
      return abstractGlobalEndRequestBuilder_;
    }

    private int globalStatus_ = 0;
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public int getGlobalStatusValue() {
      return globalStatus_;
    }
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public Builder setGlobalStatusValue(int value) {
      globalStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public io.seata.codec.protobuf.generated.GlobalStatusProto getGlobalStatus() {
      io.seata.codec.protobuf.generated.GlobalStatusProto result = io.seata.codec.protobuf.generated.GlobalStatusProto.valueOf(globalStatus_);
      return result == null ? io.seata.codec.protobuf.generated.GlobalStatusProto.UNRECOGNIZED : result;
    }
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public Builder setGlobalStatus(io.seata.codec.protobuf.generated.GlobalStatusProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      globalStatus_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public Builder clearGlobalStatus() {
      
      globalStatus_ = 0;
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


    // @@protoc_insertion_point(builder_scope:io.seata.protocol.protobuf.GlobalReportRequestProto)
  }

  // @@protoc_insertion_point(class_scope:io.seata.protocol.protobuf.GlobalReportRequestProto)
  private static final io.seata.codec.protobuf.generated.GlobalReportRequestProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.seata.codec.protobuf.generated.GlobalReportRequestProto();
  }

  public static io.seata.codec.protobuf.generated.GlobalReportRequestProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GlobalReportRequestProto>
      PARSER = new com.google.protobuf.AbstractParser<GlobalReportRequestProto>() {
    public GlobalReportRequestProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GlobalReportRequestProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GlobalReportRequestProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GlobalReportRequestProto> getParserForType() {
    return PARSER;
  }

  public io.seata.codec.protobuf.generated.GlobalReportRequestProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

