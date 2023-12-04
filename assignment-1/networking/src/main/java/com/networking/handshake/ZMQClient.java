package com.networking.handshake;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.networking.flatbuffers.zmq.Health;
import com.networking.flatbuffers.zmq.Order;
import com.networking.utils.OrderSerializer;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;

public class ZMQClient {
    public static void main(String[] args) {
        try{
            ZContext context = new ZContext();
            Socket healthClient = context.createSocket(SocketType.REQ);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter the Health Server IP Address");
            String ipaddress = reader.readLine();
            System.out.println("Please enter the Health server Port");
            String port = reader.readLine();
            StringBuilder builder = new StringBuilder();
            builder.append("tcp://");
            builder.append(ipaddress);
            builder.append(":");
            builder.append(port);
            System.out.println("Bind Address for HealthServer is  "+builder.toString());
           // client.connect("tcp://localhost:5555");
            healthClient.connect(builder.toString());
            System.out.print("Sending serialized request to Health Server");
            long startTimeHealth = System.currentTimeMillis();
            Health health = new Health();
            byte[] healthRequest = OrderSerializer.serializeHealth(health);
            healthClient.send(healthRequest);
            long endTimeHealth = System.currentTimeMillis();
            System.out.println("Time took to send Serialized health Data" + (endTimeHealth - startTimeHealth) + "Milliseconds");
            byte[] healthResponse = healthClient.recv(0);
            System.out.print(" ===== Receiving response from  Health Server ===== ");
            OrderSerializer.displayResponseData(healthResponse);

            Socket orderClient = context.createSocket(SocketType.REQ);
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter the Order Server IP Address");
            String ipaddress1 = reader1.readLine();
            System.out.println("Please enter the Order server Port");
            String port1 = reader1.readLine();
            StringBuilder builder1 = new StringBuilder();
            builder1.append("tcp://");
            builder1.append(ipaddress1);
            builder1.append(":");
            builder1.append(port1);
            System.out.println("Bind Address for OrderServer is  "+builder1.toString());
            // client.connect("tcp://localhost:5555");
            orderClient.connect(builder1.toString());
            System.out.print("Sending serilized request to Order Server");
            long startTimeOrder = System.currentTimeMillis();
            Order order = new Order();
            byte[] orderRequest = OrderSerializer.serializeOrder(order);
            orderClient.send(orderRequest);
            long endTimeOrder = System.currentTimeMillis();
            System.out.println("Time took to send Serialized Order Data" + (endTimeOrder - startTimeOrder) + "Milliseconds");
            byte[] orderResponse = orderClient.recv(0);
            System.out.print(" ===== Received response from  Order Server ===== ");
            OrderSerializer.displayResponseData(orderResponse);


            /*byte[] response = client.recv(0);
            System.out.println("Received response: [" + new String(response, ZMQ.CHARSET) + "]");*/

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }




    }
}
