package nio.selector;


import nio.socket.nagle.Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 验证读是非阻塞的
 */
public class ReadNONBlockServer {

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

            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            System.out.println("begin:" + System.currentTimeMillis());
            socketChannel.read(byteBuffer);
            System.out.println(" end " + System.currentTimeMillis() + " position=" + byteBuffer.position());
            System.out.println("结束读操作");
        }

        channel.close();

    }
}
