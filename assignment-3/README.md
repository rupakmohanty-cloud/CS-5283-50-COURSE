# CS 4383 Programming Assignment 3
Author: Spencer Wu (wuy54, yu.heng.wu@vanderbilt.edu) <br>
Last update: 12/01/2023 05:50 PM CST <br>
[Link to the demo video](https://drive.google.com/file/d/1t2bC6QUh4MqDzVpGhJH4WD1Vt54DU87a/view?usp=sharing) <br> <br>

vm1: 192.168.5.244 <br>
vm2: 192.168.5.73

### Milestone 1
1. Install UERANSIM on vm1 following the instruction @ https://github.com/aligungr/UERANSIM/wiki
2. Install open5GS on vm2 following the instruction @ https://open5gs.org/open5gs/docs/guide/01-quickstart/
3. Put the modified custom-open5gs-gnb.yaml and modified custom-open5gs-ue.yaml in ~/UERANSIM/config/ on vm1
4. cd into open5gs on vm2
5. Put the modified amf.yaml and modified upf.yaml in /etc/open5gs/ on vm2
6. Reenter the vm2 from the local machine with `ssh -L 3000:localhost:3000 vm2`. Go to localhost:3000 on firefox and add a new subscriver with 
imsi `001010000000001`
7. When logging into the webUI, the username is `admin` and the password is `1423`
8. Enter UERANSIM/build and issue `./nr-gnb -c ../config/custom-open5gs-gnb.yaml` on vm1
9. You can check the log of open5GS on vm2 with `sudo tail -f /var/log/open5gs/amf.log`
10. Open another terminal tab and ssh into vm1. Issue `sudo ./nr-ue -c ../config/custom-open5gs-ue.yaml` at ~/UERANSIM/build/
11. `chmod +x ./nr-binder` to ensure the script is executable.
12. Install iperf3 with `sudo apt install iperf3` on both vms
13. Start the iperf3 server on vm2 with `iperf3 -s`
14. on vm1, cd into UERANSIM/build
15. Start the iperf3 clien on vm1 through nr-binder with `./nr-binder <address for uesimtun0 interface> iperf3 -c 192.168.5.73 -p 5201`

### Milestone 2
uesimtun0: 10.45.0.2 (the time I ran it) <br>
d2: 10.10.6.252 <br>
du1: 100.85.10.251 (grocery) <br>
dr1: 172.121.10.252 (health) <br>
1. Start the left.py from pa2 on vm1 with `sudo -E left.py` and the right.py from pa2 on vm2 with `sudo -E right.py`
2. Open the xterm on d2 in the left topo and the xterm on dr1, du1 on the right topo.
3. Go into zmq/grpc folder in the pa1 folder that copied into the remote vms and the execute the grpc_server.py/zmq_server_order.py on du1 (right/vm2), the grpc_server_health.py/zmq_server_health.py on dr1 (right/vm2), and the grpc_client.py/zmq_client.py on d2 (left/vm1).
4. In either the zmq folder or the grpc folder in the pa1 repo folder, execute <br>
`../../../UERANSIM/build/nr-binder <uesimtun0 address> python3 <zmq_client.py or grpc_client.py> -a1 10.85.100.251 -a2 172.121.10.252`
