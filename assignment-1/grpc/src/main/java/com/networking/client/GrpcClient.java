package com.networking.client;

import com.networking.grpc.ProtoServiceGrpc;
import com.networking.grpc.Schema;
import com.networking.utils.ReadWriteUtilities;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class GrpcClient {

    public void sendOrderData(String ipAddress,String port) {
        System.out.println("==== Sending Order Data ====");
        for(int i=0;i<5;i++) {
            long startTime = System.currentTimeMillis();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(ipAddress, Integer.parseInt(port))
                    .usePlaintext()
                    .build();
            ProtoServiceGrpc.ProtoServiceBlockingStub stub = ProtoServiceGrpc.newBlockingStub(channel);
            Schema.Request request = ReadWriteUtilities.orderRequestBuilder();
            Schema.Order order = request.getOrder();
            System.out.println("Sending Order request to  Order Server");
            Schema.Response response = stub.sendData(request);
            long endTime = System.currentTimeMillis();
            System.out.println("Order request sent successfully to Order Server");
            System.out.println(" Time taken to send order data ---->" + " : " + (endTime - startTime) + "millisecond");
            System.out.println("Response Received from Order Server");
            ReadWriteUtilities.readResposne(response);
        }

    }
    public void sendHealthData(String ipAddress,String port) {
        System.out.println("==== Sending Health Data ====");
        for(int i=0;i<5;i++) {
            long startTime = System.currentTimeMillis();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(ipAddress, Integer.parseInt(port))
                    .usePlaintext()
                    .build();
            ProtoServiceGrpc.ProtoServiceBlockingStub stub = ProtoServiceGrpc.newBlockingStub(channel);
            Schema.Request request = ReadWriteUtilities.healthRequestBuilder();
            Schema.Health health = request.getHealth();
            System.out.println("Sending Order request to  Health Server");
            Schema.Response response = stub.sendData(request);
            long endTime = System.currentTimeMillis();
            System.out.println("Order request sent successfully to Health Server");
            System.out.println(" Time taken to send Health data ---->" + " : " + (endTime - startTime) + "millisecond");
            System.out.println("Response Received from Health Server");
            ReadWriteUtilities.readResposne(response);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcClient client = new GrpcClient();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the IP Address to connect to Order Server");
        String ipaddress = reader.readLine();
        System.out.println("Enter the Port to connect to Order Server");
        String port = reader.readLine();
        client.sendOrderData(ipaddress,port);
        Thread.sleep(5);
        System.out.println("Enter the IP Address to connect to Health Server");
        String ipaddress1= reader.readLine();
        System.out.println("Enter the Port to connect to Health Server");
        String port1 = reader.readLine();
        client.sendHealthData(ipaddress1,port1);

        //channel.shutdown();
    }
}
