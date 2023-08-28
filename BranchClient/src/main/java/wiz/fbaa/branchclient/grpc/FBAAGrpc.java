package wiz.fbaa.branchclient.grpc;

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
 * <pre>
 * The Fantastic Beasts Adoption Agency service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: fbaa.proto")
public final class FBAAGrpc {

  private FBAAGrpc() {}

  public static final String SERVICE_NAME = "fbaa.FBAA";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest,
      com.google.protobuf.Empty> getAddCreatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCreature",
      requestType = wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest,
      com.google.protobuf.Empty> getAddCreatureMethod() {
    io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest, com.google.protobuf.Empty> getAddCreatureMethod;
    if ((getAddCreatureMethod = FBAAGrpc.getAddCreatureMethod) == null) {
      synchronized (FBAAGrpc.class) {
        if ((getAddCreatureMethod = FBAAGrpc.getAddCreatureMethod) == null) {
          FBAAGrpc.getAddCreatureMethod = getAddCreatureMethod = 
              io.grpc.MethodDescriptor.<wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fbaa.FBAA", "AddCreature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new FBAAMethodDescriptorSupplier("AddCreature"))
                  .build();
          }
        }
     }
     return getAddCreatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest,
      wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> getStreamCreaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCreatures",
      requestType = wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest.class,
      responseType = wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest,
      wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> getStreamCreaturesMethod() {
    io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest, wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> getStreamCreaturesMethod;
    if ((getStreamCreaturesMethod = FBAAGrpc.getStreamCreaturesMethod) == null) {
      synchronized (FBAAGrpc.class) {
        if ((getStreamCreaturesMethod = FBAAGrpc.getStreamCreaturesMethod) == null) {
          FBAAGrpc.getStreamCreaturesMethod = getStreamCreaturesMethod = 
              io.grpc.MethodDescriptor.<wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest, wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "fbaa.FBAA", "StreamCreatures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FBAAMethodDescriptorSupplier("StreamCreatures"))
                  .build();
          }
        }
     }
     return getStreamCreaturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest,
      wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> getGetCreatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCreature",
      requestType = wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest.class,
      responseType = wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest,
      wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> getGetCreatureMethod() {
    io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest, wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> getGetCreatureMethod;
    if ((getGetCreatureMethod = FBAAGrpc.getGetCreatureMethod) == null) {
      synchronized (FBAAGrpc.class) {
        if ((getGetCreatureMethod = FBAAGrpc.getGetCreatureMethod) == null) {
          FBAAGrpc.getGetCreatureMethod = getGetCreatureMethod = 
              io.grpc.MethodDescriptor.<wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest, wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fbaa.FBAA", "GetCreature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FBAAMethodDescriptorSupplier("GetCreature"))
                  .build();
          }
        }
     }
     return getGetCreatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest,
      com.google.protobuf.Empty> getReserveCreatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveCreature",
      requestType = wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest,
      com.google.protobuf.Empty> getReserveCreatureMethod() {
    io.grpc.MethodDescriptor<wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest, com.google.protobuf.Empty> getReserveCreatureMethod;
    if ((getReserveCreatureMethod = FBAAGrpc.getReserveCreatureMethod) == null) {
      synchronized (FBAAGrpc.class) {
        if ((getReserveCreatureMethod = FBAAGrpc.getReserveCreatureMethod) == null) {
          FBAAGrpc.getReserveCreatureMethod = getReserveCreatureMethod = 
              io.grpc.MethodDescriptor.<wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fbaa.FBAA", "ReserveCreature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new FBAAMethodDescriptorSupplier("ReserveCreature"))
                  .build();
          }
        }
     }
     return getReserveCreatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FBAAStub newStub(io.grpc.Channel channel) {
    return new FBAAStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FBAABlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FBAABlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FBAAFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FBAAFutureStub(channel);
  }

  /**
   * <pre>
   * The Fantastic Beasts Adoption Agency service definition.
   * </pre>
   */
  public static abstract class FBAAImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Adds a creature
     * </pre>
     */
    public void addCreature(wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCreatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stream creatures
     * </pre>
     */
    public void streamCreatures(wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest request,
        io.grpc.stub.StreamObserver<wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamCreaturesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a creature
     * </pre>
     */
    public void getCreature(wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest request,
        io.grpc.stub.StreamObserver<wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCreatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Reserves a creature
     * </pre>
     */
    public void reserveCreature(wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getReserveCreatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddCreatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ADD_CREATURE)))
          .addMethod(
            getStreamCreaturesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest,
                wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse>(
                  this, METHODID_STREAM_CREATURES)))
          .addMethod(
            getGetCreatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest,
                wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse>(
                  this, METHODID_GET_CREATURE)))
          .addMethod(
            getReserveCreatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_RESERVE_CREATURE)))
          .build();
    }
  }

  /**
   * <pre>
   * The Fantastic Beasts Adoption Agency service definition.
   * </pre>
   */
  public static final class FBAAStub extends io.grpc.stub.AbstractStub<FBAAStub> {
    private FBAAStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FBAAStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FBAAStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FBAAStub(channel, callOptions);
    }

    /**
     * <pre>
     * Adds a creature
     * </pre>
     */
    public void addCreature(wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCreatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stream creatures
     * </pre>
     */
    public void streamCreatures(wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest request,
        io.grpc.stub.StreamObserver<wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamCreaturesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a creature
     * </pre>
     */
    public void getCreature(wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest request,
        io.grpc.stub.StreamObserver<wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCreatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reserves a creature
     * </pre>
     */
    public void reserveCreature(wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReserveCreatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Fantastic Beasts Adoption Agency service definition.
   * </pre>
   */
  public static final class FBAABlockingStub extends io.grpc.stub.AbstractStub<FBAABlockingStub> {
    private FBAABlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FBAABlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FBAABlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FBAABlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Adds a creature
     * </pre>
     */
    public com.google.protobuf.Empty addCreature(wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddCreatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stream creatures
     * </pre>
     */
    public java.util.Iterator<wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> streamCreatures(
        wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamCreaturesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a creature
     * </pre>
     */
    public wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse getCreature(wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCreatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reserves a creature
     * </pre>
     */
    public com.google.protobuf.Empty reserveCreature(wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest request) {
      return blockingUnaryCall(
          getChannel(), getReserveCreatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Fantastic Beasts Adoption Agency service definition.
   * </pre>
   */
  public static final class FBAAFutureStub extends io.grpc.stub.AbstractStub<FBAAFutureStub> {
    private FBAAFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FBAAFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FBAAFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FBAAFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Adds a creature
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addCreature(
        wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCreatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a creature
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse> getCreature(
        wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCreatureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Reserves a creature
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> reserveCreature(
        wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReserveCreatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CREATURE = 0;
  private static final int METHODID_STREAM_CREATURES = 1;
  private static final int METHODID_GET_CREATURE = 2;
  private static final int METHODID_RESERVE_CREATURE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FBAAImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FBAAImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CREATURE:
          serviceImpl.addCreature((wiz.fbaa.branchclient.grpc.Fbaa.AddCreatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_STREAM_CREATURES:
          serviceImpl.streamCreatures((wiz.fbaa.branchclient.grpc.Fbaa.StreamCreatureRequest) request,
              (io.grpc.stub.StreamObserver<wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse>) responseObserver);
          break;
        case METHODID_GET_CREATURE:
          serviceImpl.getCreature((wiz.fbaa.branchclient.grpc.Fbaa.GetCreatureRequest) request,
              (io.grpc.stub.StreamObserver<wiz.fbaa.branchclient.grpc.Fbaa.CreatureResponse>) responseObserver);
          break;
        case METHODID_RESERVE_CREATURE:
          serviceImpl.reserveCreature((wiz.fbaa.branchclient.grpc.Fbaa.ReserveCreatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class FBAABaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FBAABaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return wiz.fbaa.branchclient.grpc.Fbaa.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FBAA");
    }
  }

  private static final class FBAAFileDescriptorSupplier
      extends FBAABaseDescriptorSupplier {
    FBAAFileDescriptorSupplier() {}
  }

  private static final class FBAAMethodDescriptorSupplier
      extends FBAABaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FBAAMethodDescriptorSupplier(String methodName) {
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
      synchronized (FBAAGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FBAAFileDescriptorSupplier())
              .addMethod(getAddCreatureMethod())
              .addMethod(getStreamCreaturesMethod())
              .addMethod(getGetCreatureMethod())
              .addMethod(getReserveCreatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
