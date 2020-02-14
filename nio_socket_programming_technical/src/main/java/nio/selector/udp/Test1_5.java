package nio.selector.udp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Test1_5 {

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
        datagramChannel.join(InetAddress.getByName("224.0.0.5"),
                NetworkInterface.getByInetAddress(InetAddress.getByName("192.168.1.148")));

        datagramChannel.bind(new InetSocketAddress("192.168.1.148", 8088));
        datagramChannel.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey = datagramChannel.register(selector, SelectionKey.OP_READ);

        boolean isRun = true;
        while (isRun){
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isReadable()){
                    datagramChannel = (DatagramChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1000);
                    datagramChannel.read(buffer);
                    System.out.println(new String(buffer.array(), 0, buffer.position()));
                }
                iterator.remove();
            }
        }

        datagramChannel.close();

    }
}
