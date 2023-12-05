# CS 4383 Programming Assignment 3

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
