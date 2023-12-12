# Computer Networking Projects

## SDN-based Network Traffic Control

The project utilizes Mininet, a powerful tool for emulating SDN (Software Defined Network), to construct a simple SDN network topology and simulate traffic control within the Mininet-emulated environment. The primary objective is to develop two different SDN controller applications using [Ryu](https://github.com/faucetsdn/ryu) framework to implement traffic forwarding and redirection, respectively. The controller application that implements traffic forwarding directly forwards network traffic from Client to Server 1, while the other one redirects the traffic to Server 2 without the awareness of Client.


### Recording of the demo 
 
  Recording of the project demo is available at below link

  https://drive.google.com/file/d/1wDGVsZSYRd1N7k6fNG50eo0kyULVUeZC/view?usp=sharing
    
 



### Requirements_SDN
- Linux environment (Ubuntu 22.04)
- Python2
- Python3
- Mininet (2.2.2)
- Ryu (4.34)
- Xterm (353)

### Issues with RYU and python version 3.9 and above 

There are some issues with the RYU controller and the latest version of python so make sure to run the folloiwng command 

- sudo add-apt-repository ppa:deadsnakes/ppa
- sudo apt-get install virtualenv python3.9 python3.9-distutils

- #create the virtualenv 
- virtualenv -p`which python3.9` ryu-python3.9-venv
- source ryu-python3.9-venv/bin/activate
- echo $VIRTUAL_ENV #check if we are indeed in the virtual environment
- pip install ryu
- pip uninstall eventlet
- pip install eventlet==0.30.2
- ryu-manager --help

### Usage_SDN
1. Construct the network topology by running the command in the terminal
```
 sudo python2 networkTopo.py
```

2. Five subterminals appear, then run the controller application in the terminal named Controller .Please make sure to run the steps as mentioned in section(Issues with RYU and python version 3.9 and above )
```
 ryu-manager ryu_forward.py 
```
or 
```
 ryu-manager ryu_redirect.py 
```

3. Run server.py on the Server1 and Server2, then run client.py on Client node.
```
 python3 server.py
```
```
 python3 client.py
```
4. Observe subterminals info.

### Document_SDN
For more detailed info, please [click](./network_traffic_control/Report/Report_PartII.pdf) to read the report for this project.


