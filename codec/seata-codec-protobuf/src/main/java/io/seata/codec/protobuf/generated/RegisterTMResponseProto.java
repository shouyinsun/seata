// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: registerTMResponse.proto

package io.seata.codec.protobuf.generated;

/**
 * <pre>
 * PublishRequest is a publish request.
 * </pre>
 *
 * Protobuf type {@code io.seata.protocol.protobuf.RegisterTMResponseProto}
 */
public  final class RegisterTMResponseProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.seata.protocol.protobuf.RegisterTMResponseProto)
    RegisterTMResponseProtoOrBuilder {
  // Use RegisterTMResponseProto.newBuilder() to construct.
  private RegisterTMResponseProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RegisterTMResponseProto() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private RegisterTMResponseProto(
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
            io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.Builder subBuilder = null;
            if (abstractIdentifyResponse_ != null) {
              subBuilder = abstractIdentifyResponse_.toBuilder();
            }
            abstractIdentifyResponse_ = input.readMessage(io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(abstractIdentifyResponse_);
              abstractIdentifyResponse_ = subBuilder.buildPartial();
            }

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
    return io.seata.codec.protobuf.generated.RegisterTMResponse.internal_static_io_seata_protocol_protobuf_RegisterTMResponseProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.seata.codec.protobuf.generated.RegisterTMResponse.internal_static_io_seata_protocol_protobuf_RegisterTMResponseProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.seata.codec.protobuf.generated.RegisterTMResponseProto.class, io.seata.codec.protobuf.generated.RegisterTMResponseProto.Builder.class);
  }

  public static final int ABSTRACTIDENTIFYRESPONSE_FIELD_NUMBER = 1;
  private io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto abstractIdentifyResponse_;
  /**
   * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
   */
  public boolean hasAbstractIdentifyResponse() {
    return abstractIdentifyResponse_ != null;
  }
  /**
   * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
   */
  public io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto getAbstractIdentifyResponse() {
    return abstractIdentifyResponse_ == null ? io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.getDefaultInstance() : abstractIdentifyResponse_;
  }
  /**
   * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
   */
  public io.seata.codec.protobuf.generated.AbstractIdentifyResponseProtoOrBuilder getAbstractIdentifyResponseOrBuilder() {
    return getAbstractIdentifyResponse();
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
    if (abstractIdentifyResponse_ != null) {
      output.writeMessage(1, getAbstractIdentifyResponse());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (abstractIdentifyResponse_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAbstractIdentifyResponse());
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
    if (!(obj instanceof io.seata.codec.protobuf.generated.RegisterTMResponseProto)) {
      return super.equals(obj);
    }
    io.seata.codec.protobuf.generated.RegisterTMResponseProto other = (io.seata.codec.protobuf.generated.RegisterTMResponseProto) obj;

    boolean result = true;
    result = result && (hasAbstractIdentifyResponse() == other.hasAbstractIdentifyResponse());
    if (hasAbstractIdentifyResponse()) {
      result = result && getAbstractIdentifyResponse()
          .equals(other.getAbstractIdentifyResponse());
    }
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasAbstractIdentifyResponse()) {
      hash = (37 * hash) + ABSTRACTIDENTIFYRESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getAbstractIdentifyResponse().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto parseFrom(
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
  public static Builder newBuilder(io.seata.codec.protobuf.generated.RegisterTMResponseProto prototype) {
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
   * Protobuf type {@code io.seata.protocol.protobuf.RegisterTMResponseProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.seata.protocol.protobuf.RegisterTMResponseProto)
      io.seata.codec.protobuf.generated.RegisterTMResponseProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.seata.codec.protobuf.generated.RegisterTMResponse.internal_static_io_seata_protocol_protobuf_RegisterTMResponseProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.seata.codec.protobuf.generated.RegisterTMResponse.internal_static_io_seata_protocol_protobuf_RegisterTMResponseProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.seata.codec.protobuf.generated.RegisterTMResponseProto.class, io.seata.codec.protobuf.generated.RegisterTMResponseProto.Builder.class);
    }

    // Construct using io.seata.codec.protobuf.generated.RegisterTMResponseProto.newBuilder()
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
      if (abstractIdentifyResponseBuilder_ == null) {
        abstractIdentifyResponse_ = null;
      } else {
        abstractIdentifyResponse_ = null;
        abstractIdentifyResponseBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.seata.codec.protobuf.generated.RegisterTMResponse.internal_static_io_seata_protocol_protobuf_RegisterTMResponseProto_descriptor;
    }

    public io.seata.codec.protobuf.generated.RegisterTMResponseProto getDefaultInstanceForType() {
      return io.seata.codec.protobuf.generated.RegisterTMResponseProto.getDefaultInstance();
    }

    public io.seata.codec.protobuf.generated.RegisterTMResponseProto build() {
      io.seata.codec.protobuf.generated.RegisterTMResponseProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.seata.codec.protobuf.generated.RegisterTMResponseProto buildPartial() {
      io.seata.codec.protobuf.generated.RegisterTMResponseProto result = new io.seata.codec.protobuf.generated.RegisterTMResponseProto(this);
      if (abstractIdentifyResponseBuilder_ == null) {
        result.abstractIdentifyResponse_ = abstractIdentifyResponse_;
      } else {
        result.abstractIdentifyResponse_ = abstractIdentifyResponseBuilder_.build();
      }
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
      if (other instanceof io.seata.codec.protobuf.generated.RegisterTMResponseProto) {
        return mergeFrom((io.seata.codec.protobuf.generated.RegisterTMResponseProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.seata.codec.protobuf.generated.RegisterTMResponseProto other) {
      if (other == io.seata.codec.protobuf.generated.RegisterTMResponseProto.getDefaultInstance()) return this;
      if (other.hasAbstractIdentifyResponse()) {
        mergeAbstractIdentifyResponse(other.getAbstractIdentifyResponse());
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
      io.seata.codec.protobuf.generated.RegisterTMResponseProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.seata.codec.protobuf.generated.RegisterTMResponseProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto abstractIdentifyResponse_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto, io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.Builder, io.seata.codec.protobuf.generated.AbstractIdentifyResponseProtoOrBuilder> abstractIdentifyResponseBuilder_;
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    public boolean hasAbstractIdentifyResponse() {
      return abstractIdentifyResponseBuilder_ != null || abstractIdentifyResponse_ != null;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    public io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto getAbstractIdentifyResponse() {
      if (abstractIdentifyResponseBuilder_ == null) {
        return abstractIdentifyResponse_ == null ? io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.getDefaultInstance() : abstractIdentifyResponse_;
      } else {
        return abstractIdentifyResponseBuilder_.getMessage();
      }
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    public Builder setAbstractIdentifyResponse(io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto value) {
      if (abstractIdentifyResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        abstractIdentifyResponse_ = value;
        onChanged();
      } else {
        abstractIdentifyResponseBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    public Builder setAbstractIdentifyResponse(
        io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.Builder builderForValue) {
      if (abstractIdentifyResponseBuilder_ == null) {
        abstractIdentifyResponse_ = builderForValue.build();
        onChanged();
      } else {
        abstractIdentifyResponseBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    public Builder mergeAbstractIdentifyResponse(io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto value) {
      if (abstractIdentifyResponseBuilder_ == null) {
        if (abstractIdentifyResponse_ != null) {
          abstractIdentifyResponse_ =
            io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.newBuilder(abstractIdentifyResponse_).mergeFrom(value).buildPartial();
        } else {
          abstractIdentifyResponse_ = value;
        }
        onChanged();
      } else {
        abstractIdentifyResponseBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    public Builder clearAbstractIdentifyResponse() {
      if (abstractIdentifyResponseBuilder_ == null) {
        abstractIdentifyResponse_ = null;
        onChanged();
      } else {
        abstractIdentifyResponse_ = null;
        abstractIdentifyResponseBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    public io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.Builder getAbstractIdentifyResponseBuilder() {
      
      onChanged();
      return getAbstractIdentifyResponseFieldBuilder().getBuilder();
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    public io.seata.codec.protobuf.generated.AbstractIdentifyResponseProtoOrBuilder getAbstractIdentifyResponseOrBuilder() {
      if (abstractIdentifyResponseBuilder_ != null) {
        return abstractIdentifyResponseBuilder_.getMessageOrBuilder();
      } else {
        return abstractIdentifyResponse_ == null ?
            io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.getDefaultInstance() : abstractIdentifyResponse_;
      }
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractIdentifyResponseProto abstractIdentifyResponse = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto, io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.Builder, io.seata.codec.protobuf.generated.AbstractIdentifyResponseProtoOrBuilder> 
        getAbstractIdentifyResponseFieldBuilder() {
      if (abstractIdentifyResponseBuilder_ == null) {
        abstractIdentifyResponseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto, io.seata.codec.protobuf.generated.AbstractIdentifyResponseProto.Builder, io.seata.codec.protobuf.generated.AbstractIdentifyResponseProtoOrBuilder>(
                getAbstractIdentifyResponse(),
                getParentForChildren(),
                isClean());
        abstractIdentifyResponse_ = null;
      }
      return abstractIdentifyResponseBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:io.seata.protocol.protobuf.RegisterTMResponseProto)
  }

  // @@protoc_insertion_point(class_scope:io.seata.protocol.protobuf.RegisterTMResponseProto)
  private static final io.seata.codec.protobuf.generated.RegisterTMResponseProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.seata.codec.protobuf.generated.RegisterTMResponseProto();
  }

  public static io.seata.codec.protobuf.generated.RegisterTMResponseProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RegisterTMResponseProto>
      PARSER = new com.google.protobuf.AbstractParser<RegisterTMResponseProto>() {
    public RegisterTMResponseProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RegisterTMResponseProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RegisterTMResponseProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RegisterTMResponseProto> getParserForType() {
    return PARSER;
  }

  public io.seata.codec.protobuf.generated.RegisterTMResponseProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

