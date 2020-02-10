package nio.selector;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 验证写是非阻塞的
 * limit=1073741823
 * begin:1581315524808
 *  end 1581315527033 position=261676
 * 结束写操作
 */
public class WriteNONBlockServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress("localhost", 8088));

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        selector.select();
        Set<SelectionKey> set = selector.selectedKeys();
        Iterator<SelectionKey> iterator = set.iterator();
        while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);

            ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.MAX_VALUE/2);

            System.out.println("limit=" + byteBuffer.limit());
            System.out.println("begin:" + System.currentTimeMillis());
            socketChannel.write(byteBuffer);
            System.out.println(" end " + System.currentTimeMillis() + " position=" + byteBuffer.position());
            System.out.println("结束写操作");
        }

        channel.close();

    }
}
