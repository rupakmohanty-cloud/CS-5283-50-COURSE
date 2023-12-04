package com.networking.handshake;

import com.networking.flatbuffers.zmq.Response;
import com.networking.utils.OrderSerializer;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZMQOrderServer {
    public static void main(String[] args) {
        try{
            ZContext context = new ZContext();
            ZMQ.Socket server = context.createSocket(SocketType.REP);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter the server IP Address");
            String ipaddress = reader.readLine();
            System.out.println("Please enter the server Port");
            String port = reader.readLine();
            StringBuilder builder = new StringBuilder();
            builder.append("tcp://");
            builder.append(ipaddress);
            builder.append(":");
            builder.append(port);
            System.out.println("Bind Address is "+builder.toString());
            // server.bind("tcp://*:5555");
            server.bind(builder.toString());
            Response response = new Response();
            while(!Thread.currentThread().isInterrupted()){
                // Block until a message is received

                byte[] reply = server.recv(0);
                System.out.println("Received the serialized message");
                long startTime = System.currentTimeMillis();
                OrderSerializer.deserializeHealth(reply);
                long endTime = System.currentTimeMillis();
                System.out.println("Deserialization took  " + (endTime-startTime) +  " Milliseconds");
                System.out.println("Contents of received order message" );
                OrderSerializer.displayOrder(reply);

                /*StringBuilder builder1 = new StringBuilder();
                builder1.append("response code = 0");
                builder1.append(" : ");
                builder1.append("response content  = received successfully");

                String responseData = builder1.toString();
                server.send(responseData.getBytes(ZMQ.CHARSET), 0);*/

                // Send a response
                byte[] res = OrderSerializer.serializeResponse(new Response());
                server.send(res);


            }




        }catch(Exception ex){
            System.out.println("Exception occurred "+ex.getMessage());
        }
    }
}
