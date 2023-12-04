package com.networking.server;

import com.networking.grpc.ProtoServiceGrpc;
import com.networking.grpc.Schema;
import com.networking.utils.ReadWriteUtilities;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HealthServerService extends ProtoServiceGrpc.ProtoServiceImplBase{
    @Override
    public void sendData(Schema.Request request, StreamObserver<Schema.Response> responseObserver) {
        Schema.Health health = request.getHealth();
        System.out.println("Received Health message:");
        ReadWriteUtilities.readHealthRequest(health);

        Schema.Response response = Schema.Response.newBuilder()
                .setCode(Schema.ResponseCode.OK)
                .setContents("Health Request Placed")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
class HealthServer {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the port number of Health Server");
        String port = reader.readLine();
        Server server = ServerBuilder.forPort(Integer.parseInt(port))
                .addService(new HealthServerService())
                .build();

        server.start();
        System.out.println("Health Server started. Listening on port"+Integer.parseInt(port));
        server.awaitTermination();
    }
}
