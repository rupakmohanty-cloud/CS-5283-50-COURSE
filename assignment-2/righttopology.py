from mininet.topo import Topo
from mininet.net import Mininet
from mininet.node import Node
from mininet.log import setLogLevel, info
from mininet.cli import CLI


class LinuxRouter (Node):
    def config (self, **params):
        super (LinuxRouter, self).config (**params)
        self.cmd ('sysctl net.ipv4.ip_forward=1')

    def terminate (self):
        self.cmd ('sysctl net.ipv4.ip_forward=0')
        super (LinuxRouter, self).terminate ()



class NetworkTopo (Topo):

    def build(self, **_opts):

        rp1 = self.addHost ('rp1', cls=LinuxRouter, ip='172.16.3.1/16')
        rq1 = self.addHost ('rq1', cls=LinuxRouter, ip='122.168.10.1/24')
        rr1 = self.addHost ('rr1', cls=LinuxRouter, ip='172.121.10.1/24')
        rs1 = self.addHost ('rs1', cls=LinuxRouter, ip='172.3.0.1/16')
        rt1 = self.addHost ('rt1', cls=LinuxRouter, ip='10.95.0.1/24')
        ru1 = self.addHost ('ru1', cls=LinuxRouter, ip='10.85.10.1/16')
        rv1 = self.addHost ('rv1', cls=LinuxRouter, ip='10.100.0.1/16')

       
        sp1 = self.addSwitch ('sp1')
        sq1 = self.addSwitch ('sq1')
        sr1 = self.addSwitch ('sr1')
        ss1 = self.addSwitch ('ss1')
        st1 = self.addSwitch ('st1')
        su1 = self.addSwitch ('su1')
        sv1 = self.addSwitch ('sv1')

        self.addLink (sr1,
                      rr1,
                      intfName2='rr1-eth1',
                      params2={'ip': '172.121.10.1/24'}) 
        
        self.addLink (sp1,
                      rp1,
                      intfName2='rp1-eth2',
                      params2={'ip': '172.16.3.1/16'})
        
        self.addLink (sq1,
                      rq1,
                      intfName2='rq1-eth1',
                      params2={'ip': '122.168.10.1/24'})
        
        self.addLink (ss1,
                      rs1,
                      intfName2='rs1-eth1',
                      params2={'ip': '172.3.0.1/16'})
        
        self.addLink (st1,
                      rt1,
                      intfName2='rt1-eth1',
                      params2={'ip': '10.95.0.1/24'})
        
        self.addLink (su1,
                      ru1,
                      intfName2='ru1-eth1',
                      params2={'ip': '10.85.10.1/16'})
        
        self.addLink (sv1,
                      rv1,
                      intfName2='rv1-eth1',
                      params2={'ip': '10.100.0.1/16'})


        
        dp1 = self.addHost (name='dp1',
                            ip='172.16.3.251/16',
                            defaultRoute='via 172.16.3.1')
        dp2 = self.addHost (name='dp2',
                            ip='172.16.5.252/16',
                            defaultRoute='via 172.16.3.1')
        
        dq1 = self.addHost (name='dq1',
                            ip='122.168.10.251/24',
                            defaultRoute='via 122.168.10.1')
        
        dr1 = self.addHost (name='dr1',
                            ip='172.121.10.252/24',
                            defaultRoute='via 172.121.10.1')
        
        du1 = self.addHost (name='du1',
                            ip='10.85.10.251/16',
                            defaultRoute='via 10.85.10.1')
        du2 = self.addHost (name='du2',
                            ip='10.85.8.252/16',
                            defaultRoute='via 10.85.10.1')
        
        dv1 = self.addHost (name='dv1',
                            ip='10.100.0.251/16',
                            defaultRoute='via 10.100.0.1')

        
        self.addLink (dp1, sp1)
        self.addLink (dp2, sp1)
        self.addLink (dq1, sq1)
        self.addLink (dr1, sr1)
        self.addLink (du1, su1)
        self.addLink (du2, su1)
        self.addLink (dv1, sv1)
        
        self.addLink(ru1,
                     rr1,
                     intfName1='ru1-eth3',
                     intfName2='rr1-eth4',
                     params1={'ip': '172.45.0.1/16'},
                     params2={'ip': '172.45.0.2/16'})
        
        self.addLink(ru1,
                     rs1,
                     intfName1='ru1-eth4',
                     intfName2='rs1-eth4',
                     params1={'ip': '172.40.0.1/16'},
                     params2={'ip': '172.40.0.2/16'})

        self.addLink(rp1,
                     rq1,
                     intfName1='rp1-eth3',
                     intfName2='rq1-eth2',
                     params1={'ip': '192.100.0.1/24'},
                     params2={'ip': '192.100.0.2/24'})
        
        self.addLink(rr1,
                     rp1,
                     intfName1='rr1-eth2',
                     intfName2='rp1-eth4',
                     params1={'ip': '172.80.10.1/24'},
                     params2={'ip': '172.80.10.2/24'})
        
        self.addLink(rr1,
                     rs1,
                     intfName1='rr1-eth3',
                     intfName2='rs1-eth2',
                     params1={'ip': '172.70.0.1/24'},
                     params2={'ip': '172.70.0.2/24'})
        
        self.addLink(rq1,
                     rs1,
                     intfName1='rq1-eth3',
                     intfName2='rs1-eth3',
                     params1={'ip': '172.60.0.1/24'},
                     params2={'ip': '172.60.0.2/24'})
        
        self.addLink(rq1,
                     rt1,
                     intfName1='rq1-eth4',
                     intfName2='rt1-eth2',
                     params1={'ip': '10.90.0.1/24'},
                     params2={'ip': '10.90.0.2/24'})
        
        self.addLink(rv1,
                     rq1,
                     intfName1='rv1-eth2',
                     intfName2='rq1-eth5',
                     params1={'ip': '10.20.0.1/24'},
                     params2={'ip': '10.20.0.2/24'})
        self.addLink(rv1,
                     rt1,
                     intfName1='rv1-eth3',
                     intfName2='rt1-eth3',
                     params1={'ip': '10.25.0.1/24'},
                     params2={'ip': '10.25.0.2/24'})
        self.addLink(rv1,
                     rs1,
                     intfName1='rv1-eth4',
                     intfName2='rs1-eth5',
                     params1={'ip': '10.30.0.1/24'},
                     params2={'ip': '10.30.0.2/24'})
        self.addLink(rv1,
                     ru1,
                     intfName1='rv1-eth5',
                     intfName2='ru1-eth5',
                     params1={'ip': '10.35.0.1/24'},
                     params2={'ip': '10.35.0.2/24'})


def run():
     # first, instantiate our topology. Recall that everything is hardcoded in this
    # topology
    topo = NetworkTopo ()

    # Then create the network object from this topology
    net = Mininet (topo=topo)

    net.addNAT(name='nat0', ip = '172.16.3.5').configDefault()

    # Note how the "ip route add" command is invoked on each router so that
    # they can route to each other
    
    # Add routing for reaching networks that aren't directly connected

    # # p to r
    # info (net['rp1'].cmd("ip route add 172.121.0.0/16 via 172.80.10.1 dev rp1-eth4"))
    # p to q
    info (net['rp1'].cmd("ip route add 122.168.10.0/24 via 192.100.0.2 dev rp1-eth3"))
    # p to every right topo subnet through q
    # to v
    info (net['rp1'].cmd("ip route add 10.100.0.0/16 via 192.100.0.2 dev rp1-eth3"))
    # to u
    info (net['rp1'].cmd("ip route add 10.85.0.0/16 via 192.100.0.2 dev rp1-eth3"))
    # to r
    info (net['rp1'].cmd("ip route add 172.121.10.0/24 via 192.100.0.2 dev rp1-eth3"))
    # to s
    info (net['rp1'].cmd("ip route add 172.3.0.0/24 via 192.100.0.2 dev rp1-eth3"))
    # to t
    info (net['rp1'].cmd("ip route add 10.95.0.0/24 via 192.100.0.2 dev rp1-eth3"))

    # # p interface2 to 172.16.5.0/24
    # info (net['rp1'].cmd("ip route add 172.16.5.0/24 via 172.100.0.2 dev rp1-eth2"))
    # # 172.16.5.0/24 to p
    # info (net['dp2'].cmd("ip route add default via 172.100.0.1 dev dp2-eth2"))
    
    # # q to p
    # info (net['rq1'].cmd("ip route add 172.16.3.0/16 via 192.100.0.1 dev rq1-eth2"))
    # # q to v
    # info (net['rq1'].cmd("ip route add 10.100.0.0/16 via 10.20.0.1 dev rq1-eth5"))
    # # q to t
    # info (net['rq1'].cmd("ip route add 10.95.0.0/24 via 10.90.0.2 dev rq1-eth4"))
    # q to s
    info (net['rq1'].cmd("ip route add 172.3.0.0/16 via 172.60.0.2 dev rq1-eth3"))
    # q default to s
    info (net['rq1'].cmd("ip route add default via 172.60.0.2 dev rq1-eth3"))
    
    

    # r to p
    info (net['rr1'].cmd("ip route add 172.16.0.0/16 via 172.80.10.2 dev rr1-eth2"))
    # r default to p
    info (net['rr1'].cmd("ip route add default via 172.80.10.2 dev rr1-eth2"))

    info (net['rr1'].cmd("ip route add 122.168.10.0/24 via 172.80.10.2 dev rr1-eth2"))
    info (net['rr1'].cmd("ip route add 10.100.0.0/16 via 172.80.10.2 dev rr1-eth2"))
    info (net['rr1'].cmd("ip route add 172.3.0.0/24 via 172.80.10.2 dev rr1-eth2"))
    info (net['rr1'].cmd("ip route add 10.95.0.0/24 via 172.80.10.2 dev rr1-eth2"))


    # r to u
    info (net['rr1'].cmd("ip route add 10.85.0.0/16 via 172.45.0.1 dev rr1-eth4"))


    # # r to s
    # info (net['rr1'].cmd("ip route add 172.3.0.0/16 via 172.70.0.2 dev rr1-eth3"))


    # # s to q
    # info (net['rs1'].cmd("ip route add 122.168.10.0/24 via 172.60.0.1 dev rs1-eth3"))
    # # s to u
    # info (net['rs1'].cmd("ip route add 10.85.0.0/16 via 172.40.0.1 dev rs1-eth4"))
    # s to p through r (for going to vm1)
    info (net['rs1'].cmd("ip route add 10.10.0.0/16 via 172.70.0.1 dev rs1-eth2"))
    # s to p through r
    info (net['rs1'].cmd("ip route add 172.16.0.0/16 via 172.70.0.1 dev rs1-eth2"))
    # s to r
    info (net['rs1'].cmd("ip route add 172.121.10.0/24 via 172.70.0.1 dev rs1-eth2"))
    # s to v
    info (net['rs1'].cmd("ip route add 10.100.0.0/16 via 10.30.0.1 dev rs1-eth5"))
    # s default to v
    info (net['rs1'].cmd("ip route add default via 10.30.0.1 dev rs1-eth5"))
    

    # t default to q
    info (net['rt1'].cmd("ip route add default via 10.90.0.1 dev rt1-eth2"))
    # t to q
    info (net['rt1'].cmd("ip route add 122.168.10.0/24 via 10.90.0.1 dev rt1-eth2"))

    

    # # 10.85.8.0/24 default to u
    # info (net['du2'].cmd("ip route add default via 10.50.0.1 dev du2-eth2"))
    # # u to 10.85.8.0/24 (interface 2)
    # info (net['ru1'].cmd("ip route add 10.85.8.0/24 via 10.50.0.2 dev ru1-eth2"))
    # # u to r
    # info (net['ru1'].cmd("ip route add 172.121.10.0/24 via 172.45.0.2 dev ru1-eth3"))
    # u to s
    info (net['ru1'].cmd("ip route add 172.3.0.0/16 via 172.40.0.2 dev ru1-eth4"))
    # u default to s
    info (net['ru1'].cmd("ip route add default via 172.40.0.2 dev ru1-eth4"))


    # v to u
    info (net['rv1'].cmd("ip route add 10.85.0.0/16 via 10.35.0.2 dev rv1-eth5"))
    # # v to t
    # info (net['rv1'].cmd("ip route add 10.95.0.0/24 via 10.25.0.2 dev rv1-eth3"))
    # v default to t
    info (net['rv1'].cmd("ip route add default via 10.25.0.2 dev rv1-eth3"))

    # info (net['dp1'].cmd("ip route add default via 172.16.3.1 dev dp1-eth0"))
    # info (net['dp2'].cmd("ip route add default via 172.16.3.1 dev dp2-eth0"))

    # dp1 to q
    info (net['dp1'].cmd("ip route add 122.168.10.0/24 via 172.16.3.1 dev dp1-eth0"))
    # dp1 to every right topo subnet through p
    # to v
    info (net['dp1'].cmd("ip route add 10.100.0.0/16 via 172.16.3.1 dev dp1-eth0"))
    # to u
    info (net['dp1'].cmd("ip route add 10.85.0.0/16 via 172.16.3.1 dev dp1-eth0"))
    # to r
    info (net['dp1'].cmd("ip route add 172.121.10.0/24 via 172.16.3.1 dev dp1-eth0"))
    # to s
    info (net['dp1'].cmd("ip route add 172.3.0.0/24 via 172.16.3.1 dev dp1-eth0"))
    # to t
    info (net['dp1'].cmd("ip route add 10.95.0.0/24 via 172.16.3.1 dev dp1-eth0"))

    # dp2 to q
    info (net['dp2'].cmd("ip route add 122.168.10.0/24 via 172.16.3.1 dev dp2-eth0"))
    # dp2 to every right topo subnet through p
    # to v
    info (net['dp2'].cmd("ip route add 10.100.0.0/16 via 172.16.3.1 dev dp2-eth0"))
    # to u
    info (net['dp2'].cmd("ip route add 10.85.0.0/16 via 172.16.3.1 dev dp2-eth0"))
    # to r
    info (net['dp2'].cmd("ip route add 172.121.10.0/24 via 172.16.3.1 dev dp2-eth0"))
    # to s
    info (net['dp2'].cmd("ip route add 172.3.0.0/24 via 172.16.3.1 dev dp2-eth0"))
    # to t
    info (net['dp2'].cmd("ip route add 10.95.0.0/24 via 172.16.3.1 dev dp2-eth0"))

    info (net['dq1'].cmd("ip route add default via 122.168.10.1 dev dq1-eth0"))
    info (net['dr1'].cmd("ip route add default via 172.121.10.1 dev dr1-eth0"))
    info (net['dv1'].cmd("ip route add default via 10.100.0.1 dev dv1-eth0"))
    info (net['du1'].cmd("ip route add default via 10.85.10.1 dev du1-eth0"))
    info (net['du2'].cmd("ip route add default via 10.85.10.1 dev du2-eth0"))

    info (net['sp1'].cmd("ip link add vxlan0 type vxlan id 100 local 192.168.5.212 remote 192.168.5.223 dev ens3 dstport 4789"))
    info (net['sp1'].cmd("ip addr add 192.168.100.3/24 dev vxlan0"))
    info (net['sp1'].cmd("ip link set vxlan0 up"))
    info (net['sp1'].cmd("ip route add 10.10.0.0/16 via 192.168.100.2 dev vxlan0"))

    info (net['sp1'].cmd("ip route add 172.121.0.0/16 via 172.16.3.1 dev nat0-eth0"))

    info (net['nat0'].cmd("ip route add 172.121.0.0/16 via 172.16.3.1 dev nat0-eth0"))

    info(net['nat0'].cmd("ip route del default"))
    info(net['nat0'].cmd("ip route add default via 172.16.3.1 dev nat0-eth0"))
    info(net['nat0'].cmd("iptables -F"))
    info(net['nat0'].cmd("iptables -A FORWARD -i nat0-eth0 -s 192.168.100.0/24 -j ACCEPT"))
    info(net['nat0'].cmd("iptables -A FORWARD -o nat0-eth0 -d 192.168.100.0/24 -j ACCEPT"))


    net.start ()  # this method must be invoked to start the mininet
    CLI (net)   # this gives us mininet prompt
    net.stop ()  # this cleans up the network


if __name__ == '__main__':
    setLogLevel('info')
    run()