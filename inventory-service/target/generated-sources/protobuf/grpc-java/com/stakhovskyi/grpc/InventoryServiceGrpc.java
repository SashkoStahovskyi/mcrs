package com.stakhovskyi.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: inventory.proto")
public final class InventoryServiceGrpc {

  private InventoryServiceGrpc() {}

  public static final String SERVICE_NAME = "com.stakhovskyi.grpc.InventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.stakhovskyi.grpc.Inventory.InventoryRequest,
      com.stakhovskyi.grpc.Inventory.InventoryResponse> getIsInStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsInStock",
      requestType = com.stakhovskyi.grpc.Inventory.InventoryRequest.class,
      responseType = com.stakhovskyi.grpc.Inventory.InventoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.stakhovskyi.grpc.Inventory.InventoryRequest,
      com.stakhovskyi.grpc.Inventory.InventoryResponse> getIsInStockMethod() {
    io.grpc.MethodDescriptor<com.stakhovskyi.grpc.Inventory.InventoryRequest, com.stakhovskyi.grpc.Inventory.InventoryResponse> getIsInStockMethod;
    if ((getIsInStockMethod = InventoryServiceGrpc.getIsInStockMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getIsInStockMethod = InventoryServiceGrpc.getIsInStockMethod) == null) {
          InventoryServiceGrpc.getIsInStockMethod = getIsInStockMethod =
              io.grpc.MethodDescriptor.<com.stakhovskyi.grpc.Inventory.InventoryRequest, com.stakhovskyi.grpc.Inventory.InventoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IsInStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stakhovskyi.grpc.Inventory.InventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.stakhovskyi.grpc.Inventory.InventoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("IsInStock"))
              .build();
        }
      }
    }
    return getIsInStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryServiceStub newStub(io.grpc.Channel channel) {
    return new InventoryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InventoryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InventoryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class InventoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void isInStock(com.stakhovskyi.grpc.Inventory.InventoryRequest request,
        io.grpc.stub.StreamObserver<com.stakhovskyi.grpc.Inventory.InventoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIsInStockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getIsInStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.stakhovskyi.grpc.Inventory.InventoryRequest,
                com.stakhovskyi.grpc.Inventory.InventoryResponse>(
                  this, METHODID_IS_IN_STOCK)))
          .build();
    }
  }

  /**
   */
  public static final class InventoryServiceStub extends io.grpc.stub.AbstractStub<InventoryServiceStub> {
    private InventoryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void isInStock(com.stakhovskyi.grpc.Inventory.InventoryRequest request,
        io.grpc.stub.StreamObserver<com.stakhovskyi.grpc.Inventory.InventoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsInStockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class InventoryServiceBlockingStub extends io.grpc.stub.AbstractStub<InventoryServiceBlockingStub> {
    private InventoryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.stakhovskyi.grpc.Inventory.InventoryResponse isInStock(com.stakhovskyi.grpc.Inventory.InventoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getIsInStockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class InventoryServiceFutureStub extends io.grpc.stub.AbstractStub<InventoryServiceFutureStub> {
    private InventoryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.stakhovskyi.grpc.Inventory.InventoryResponse> isInStock(
        com.stakhovskyi.grpc.Inventory.InventoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getIsInStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_IS_IN_STOCK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InventoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InventoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_IS_IN_STOCK:
          serviceImpl.isInStock((com.stakhovskyi.grpc.Inventory.InventoryRequest) request,
              (io.grpc.stub.StreamObserver<com.stakhovskyi.grpc.Inventory.InventoryResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.stakhovskyi.grpc.Inventory.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryService");
    }
  }

  private static final class InventoryServiceFileDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier {
    InventoryServiceFileDescriptorSupplier() {}
  }

  private static final class InventoryServiceMethodDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InventoryServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (InventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryServiceFileDescriptorSupplier())
              .addMethod(getIsInStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
