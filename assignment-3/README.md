# CS 4383 Programming Assignment 3

### Video Recording 
   The cloud is volunerbale .It was working but having issues to connecting to Vm while trying recording . How ever knowing the fact all execution steps with screen shots are documented in the below document which is available in the repository <br>
   <b>PA3_Execution_Screenshots</b>

### Milestone 1
1. Please refer to the document <b> installation_steps </b> for instllation
2. Keep the modified custom-open5gs-gnb.yaml and modified custom-open5gs-ue.yaml in ~/UERANSIM/config/ on vm1
3. cd into open5gs on vm2
4. Keep the modified amf.yaml and modified upf.yaml in /etc/open5gs/ on vm2
5. Reenter the vm2 from the local machine with `ssh -L 3000:localhost:3000 vm2`. Go to localhost:3000 on firefox and add a new subscriver with 
imsi `001010000000001`
6. When logging into the webUI, the username is `admin` and the password is `1423`
7. Enter UERANSIM/build and issue `./nr-gnb -c ../config/custom-open5gs-gnb.yaml` on vm1
8. Check the log of open5GS on vm2 with `sudo tail -f /var/log/open5gs/amf.log`
9. Open another terminal tab and ssh into vm1. Issue `sudo ./nr-ue -c ../config/custom-open5gs-ue.yaml` at ~/UERANSIM/build/
10. `chmod +x ./nr-binder` to ensure the script is executable.
11. Install iperf3 with `sudo apt install iperf3` on both vms
12. Start the iperf3 server on vm2 with `iperf3 -s`
13. on vm1, cd into UERANSIM/build
14. Start the iperf3 clien on vm1 through nr-binder with `./nr-binder <address for uesimtun0 interface> iperf3 -c 192.168.5.73 -p 5201`

### Milestone 2
1. Start the left.py from pa2 on vm1 with `sudo -E left.py` and the right.py from pa2 on vm2 with `sudo -E right.py`
2. Open the xterm on d2 in the left topo and the xterm on dr1, du1 on the right topo.
3. run the GRPC and ZMQ programs respectively
