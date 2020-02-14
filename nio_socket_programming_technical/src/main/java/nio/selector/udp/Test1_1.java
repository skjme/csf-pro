package nio.selector.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Test1_1 {

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);

        datagramChannel.bind(new InetSocketAddress("localhost",8888));
        datagramChannel.disconnect();

        Selector selector = Selector.open();
        datagramChannel.register(selector, SelectionKey.OP_READ);

        boolean isRun = true;
        while (isRun){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isReadable()){
                    DatagramChannel channel = (DatagramChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
                    channel.receive(byteBuffer);
                    System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position()));
                }
                iterator.remove();
            }
        }
        datagramChannel.close();
    }
}
