package com.quarkus.grpc;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        String message = "Hello " + name;
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
