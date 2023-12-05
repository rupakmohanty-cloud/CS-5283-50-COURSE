# CS 4383 Programming Assignment 2
Recording for the milestones 1 can be found at following locatios 
https://drive.google.com/file/d/139w_k-8RwSe2Fe3FlKv_fMJmaBnWmnBi/view?usp=drive_link

### Prerequisite 
The two VM's are create in CH-822922 with a bastion host the IP details of which are as below
<br>ol_team5_vm-1 :192.168.5.223 
<br>ol_team5_vm-2 :192.168.5.212
<br>ol_team5_vm-1 : mininet is built with command `sudo mn --nat -i 10.10.2.0/24` on vm1
<br>ol_team5_vm-2 : mininet is built with command `sudo mn --nat -i 10.10.3.0/24` on vm2 

### Milestone 1

To build the vxlan between vm1 (192.168.5.223) and vm2 (192.168.5.212): <br>
On vm1: 
```shell
sudo ip link add vxlan0 type vxlan id 100 local 192.168.5.223 remote 192.168.5.212 dev ens3 dstport 4789
sudo ip addr add 192.168.100.2/24 dev vxlan0
sudo ip link set vxlan0 up
sudo ip route add 10.10.3.0/24 via 192.168.100.3 dev vxlan0
```
<br>

On vm2: 
```shell
sudo ip link add vxlan0 type vxlan id 100 local 192.168.5.212 remote 192.168.5.223 dev ens3 dstport 4789
sudo ip addr add 192.168.100.3/24 dev vxlan0
sudo ip link set vxlan0 up
sudo ip route add 10.10.2.0/24 via 192.168.100.2 dev vxlan0
```
 <br>
 ### Milestone 2
 `sudo python3 lefttopology.py` on vm1 for left topo and `sudo python3 righttopology.py` on vm2 for right topo.
  Ran the grpc client on d2() in the lefttopology and grpc servers on dr1(172.121.10.252) and du1(10.85.10.251) respectively <br>
  The experiment ran for 3 cycles and the teh result captured. <br>

  The latency comparision chart is captured in latency.png file 

