# CS-5382 Computer Networking Assignment -2

## Recording for the milestones :
Recording for the milestones 1 can be found at following locatios
https://drive.google.com/file/d/1D-TORSWGN2uoq8z2u7tIIJXgadvb3nLM/view?usp=sharing

## Milestone1 documents :
    Please refer to the document milestone-1 for detail explnation of milestone-1 along with commands.

To build the vxlan between vm1 (192.168.56.101) and vm2 (192.168.56.103):
On vm1:

sudo ip link add vxlan0 type vxlan id 100 local 192.168.56.101 remote 192.168.56.103 dev ens3 dstport 4789
sudo ip addr add 192.168.100.2/24 dev vxlan0
sudo ip link set vxlan0 up
sudo ip route add 10.10.2.0/24 via 192.168.56.103 dev enp0s8

On vm2:

sudo ip link add vxlan0 type vxlan id 100 local 192.168.5.73 remote 192.168.5.244 dev ens3 dstport 4789
sudo ip addr add 192.168.100.3/24 dev vxlan0
sudo ip link set vxlan0 up
sudo ip route add 10.10.1.0/24 via 192.168.56.101 dev enp0s8
 


## Required Packages




### Dependencies Installation


## Description of Project Folders 






## How to run the program for differrent milestone

   ### To run man programs for milestone-1:    
    

   ### To run man programs for milestone-2:
    

    ### Run the following to generate graphs:    
 




