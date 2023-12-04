package com.networking.server;

import com.networking.grpc.ProtoServiceGrpc;
import com.networking.grpc.Schema;
import com.networking.utils.ReadWriteUtilities;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderServerService extends ProtoServiceGrpc.ProtoServiceImplBase {
    @Override
    public void sendData(Schema.Request request, StreamObserver<Schema.Response> responseObserver) {
        Schema.Order order = request.getOrder();
        System.out.println("Received Order message:");
        ReadWriteUtilities.readOrderRequest(order);

        Schema.Response response = Schema.Response.newBuilder()
                .setCode(Schema.ResponseCode.OK)
                .setContents("Order Placed")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

 class OrderServer {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the port number of Order Server");
        String port = reader.readLine();
        Server server = ServerBuilder.forPort(Integer.parseInt(port))
                .addService(new OrderServerService())
                .build();

        server.start();
        System.out.println("Order Server started. Listening on port ..."+Integer.parseInt(port));
        server.awaitTermination();
    }
}
