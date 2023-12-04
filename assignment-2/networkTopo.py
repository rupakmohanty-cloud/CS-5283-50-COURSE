from mininet.net import Mininet
from mininet.node import Controller
from mininet.link import TCLink
from mininet.cli import CLI
from mininet.log import setLogLevel, info

def topology():
    net = Mininet(controller=Controller, link=TCLink)

    # Add hosts
    h1 = net.addHost('h1')
    h2 = net.addHost('h2')

    # Add switch
    s1 = net.addSwitch('s1')

    # Add controller
    c1 = net.addController('c1')

    # Add links with different properties
    net.addLink(h1, s1, bw=10, delay='5ms', loss=1)  # Bandwidth=10Mbps, Delay=5ms, Loss=1%
    net.addLink(h2, s1, bw=20, delay='2ms', loss=0)  # Bandwidth=20Mbps, Delay=2ms, Loss=0%

    net.build()
    c1.start()
    s1.start([c1])

    CLI(net)

    net.stop()

if __name__ == '__main__':
    topology()
