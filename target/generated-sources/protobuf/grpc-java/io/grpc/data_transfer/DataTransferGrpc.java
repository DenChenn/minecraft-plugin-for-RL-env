package io.grpc.data_transfer;

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
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: learning_data.proto")
public final class DataTransferGrpc {

  private DataTransferGrpc() {}

  public static final String SERVICE_NAME = "DataTransfer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.data_transfer.LearningData.Data,
      io.grpc.data_transfer.LearningData.ModelResponse> getSendDataToModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendDataToModel",
      requestType = io.grpc.data_transfer.LearningData.Data.class,
      responseType = io.grpc.data_transfer.LearningData.ModelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.data_transfer.LearningData.Data,
      io.grpc.data_transfer.LearningData.ModelResponse> getSendDataToModelMethod() {
    io.grpc.MethodDescriptor<io.grpc.data_transfer.LearningData.Data, io.grpc.data_transfer.LearningData.ModelResponse> getSendDataToModelMethod;
    if ((getSendDataToModelMethod = DataTransferGrpc.getSendDataToModelMethod) == null) {
      synchronized (DataTransferGrpc.class) {
        if ((getSendDataToModelMethod = DataTransferGrpc.getSendDataToModelMethod) == null) {
          DataTransferGrpc.getSendDataToModelMethod = getSendDataToModelMethod = 
              io.grpc.MethodDescriptor.<io.grpc.data_transfer.LearningData.Data, io.grpc.data_transfer.LearningData.ModelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DataTransfer", "SendDataToModel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.data_transfer.LearningData.Data.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.data_transfer.LearningData.ModelResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DataTransferMethodDescriptorSupplier("SendDataToModel"))
                  .build();
          }
        }
     }
     return getSendDataToModelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataTransferStub newStub(io.grpc.Channel channel) {
    return new DataTransferStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTransferBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DataTransferBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataTransferFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DataTransferFutureStub(channel);
  }

  /**
   */
  public static abstract class DataTransferImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendDataToModel(io.grpc.data_transfer.LearningData.Data request,
        io.grpc.stub.StreamObserver<io.grpc.data_transfer.LearningData.ModelResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendDataToModelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendDataToModelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.data_transfer.LearningData.Data,
                io.grpc.data_transfer.LearningData.ModelResponse>(
                  this, METHODID_SEND_DATA_TO_MODEL)))
          .build();
    }
  }

  /**
   */
  public static final class DataTransferStub extends io.grpc.stub.AbstractStub<DataTransferStub> {
    private DataTransferStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferStub(channel, callOptions);
    }

    /**
     */
    public void sendDataToModel(io.grpc.data_transfer.LearningData.Data request,
        io.grpc.stub.StreamObserver<io.grpc.data_transfer.LearningData.ModelResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendDataToModelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataTransferBlockingStub extends io.grpc.stub.AbstractStub<DataTransferBlockingStub> {
    private DataTransferBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.data_transfer.LearningData.ModelResponse sendDataToModel(io.grpc.data_transfer.LearningData.Data request) {
      return blockingUnaryCall(
          getChannel(), getSendDataToModelMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataTransferFutureStub extends io.grpc.stub.AbstractStub<DataTransferFutureStub> {
    private DataTransferFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DataTransferFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTransferFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DataTransferFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.data_transfer.LearningData.ModelResponse> sendDataToModel(
        io.grpc.data_transfer.LearningData.Data request) {
      return futureUnaryCall(
          getChannel().newCall(getSendDataToModelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_DATA_TO_MODEL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataTransferImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataTransferImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_DATA_TO_MODEL:
          serviceImpl.sendDataToModel((io.grpc.data_transfer.LearningData.Data) request,
              (io.grpc.stub.StreamObserver<io.grpc.data_transfer.LearningData.ModelResponse>) responseObserver);
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

  private static abstract class DataTransferBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataTransferBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.data_transfer.LearningData.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataTransfer");
    }
  }

  private static final class DataTransferFileDescriptorSupplier
      extends DataTransferBaseDescriptorSupplier {
    DataTransferFileDescriptorSupplier() {}
  }

  private static final class DataTransferMethodDescriptorSupplier
      extends DataTransferBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataTransferMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataTransferGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataTransferFileDescriptorSupplier())
              .addMethod(getSendDataToModelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
