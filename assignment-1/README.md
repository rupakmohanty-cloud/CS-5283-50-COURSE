# CS-5382 Computer Networking Assignment -1

## Recording for the milestones :
Recording for the milestones can be found at following locatios
https://drive.google.com/drive/folders/1dvDQ_pej7cOXgb0BomMnI6bZi6Y8WFmP?usp=sharing

## Prerequisite to run the programs :
Please make sure following softwares/packages are installed before running the program
  1. JDK version 1.8 and above 
  2. Mininet 
  3. Git 
  4. Gradle version 6 and above
  5. Flatbuffer & Protobuff  ( Gradle dependecies will take care of auto execution via gradle build) 

 


## Required Packages

*Note: This assumes that Zookeeper is installed at /opt/zookeeper*


### Dependencies Installation
- Java:
```
$ sudo apt-get install openjdk-11-jdk
```

-Mininet
```
sudo apt-get install mininet python3-zmq python3-kazoo python3-pip openvswitch-testcontroller
pip3 install mininet
sudo ln /usr/bin/ovs-testcontroller /usr/bin/controller 
```

## Description of Project Folders 

   ### Networking :
       Contains the codebase for ZeroMq based Client Server Communication 
   ### grpc:
       Contains the codebase for GRPC based Client Server Communication 
   ### auto_run_tests :
       Contains differrent command to test various scenarios (Milestone3)  
   ### zmqexecutables :
       Contains the archived jar file to run client server on differrent mininet hosts with Zero Mq based approach 
   ### grpcexecutables:
       Contains the archived jar file to run client server on differrent mininet hosts with GRPC based approach   
   ### statistcs:
       Contains metrics of client server communication status 




## How to run the program for differrent milestone

   ### To run man programs for milestone-1:    
     - Make sure Git is install
     - Clone th eproject in your local desktop using commnd 
       git clone https://github.com/VUComputerNetworks/assignments.git
     - To execute Zero Mq based cleint server communication 
        cd zmqexecutables 
     - Launch a mininet with the appropriate topology 
         $sudo mn --topo single,3
     -  Use Xterm h1, Xterm h2 and Xterm h3 to open 3 terminals 
     -  Note down the IP address off all 3 terminals . you can use h1 for client , h2 for order server and h3 for healthserver (you can choose it of your own in any order)
     -  To run the Order server on any terminal run teh folloiwng command and pass the arguments as asked
         java -cp ./networking-1.0-SNAPSHOT.jar com.networking.handshake.ZMQOrderServer
     - To run the Health server on any terminal run teh folloiwng command and pass the arguments as asked
         java -cp ./networking-1.0-SNAPSHOT.jar com.networking.handshake.ZMQHealthServer
     - To run the client run the following command and pass the arguments as needed 
         java -cp ./networking-1.0-SNAPSHOT.jar com.networking.handshake.ZMQClient

   ### To run man programs for milestone-2:
     - Make sure Git is install
     - Clone th eproject in your local desktop using commnd 
       git clone https://github.com/VUComputerNetworks/assignments.git
     - To execute Zero Mq based cleint server communication 
        cd grpcexecutables 
     - Launch a mininet with the appropriate topology 
         $sudo mn --topo single,3
     -  Use Xterm h1, Xterm h2 and Xterm h3 to open 3 terminals 
     -  Note down the IP address off all 3 terminals . you can use h1 for client , h2 for order server and h3 for healthserver (you can choose it of your own in any order)
     -  To run the Order server on any terminal run teh folloiwng command and pass the arguments as asked
         java -cp ./grpc-1.0-SNAPSHOT.jar com.networking.server.OrderServer
     - To run the Health server on any terminal run teh folloiwng command and pass the arguments as asked
         java -cp ./grpc-1.0-SNAPSHOT.jar com.networking.server.HealthServer
     - To run the client run the following command and pass the arguments as needed 
         java -cp ./grpc-1.0-SNAPSHOT.jar com.networking.client.GrpcClient

    ### Run the following to generate graphs:    
 




