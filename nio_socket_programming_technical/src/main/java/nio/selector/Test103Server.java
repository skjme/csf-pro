package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test103Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
        serverSocketChannel1.bind(new InetSocketAddress("localhost",7777));
        serverSocketChannel1.configureBlocking(false);


        // 验证selector.select()是阻塞的
        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);


        System.out.println("-------------");

        boolean isRun = true;
        while (isRun){
            int keyCount = selector.select(); // 该方法是阻塞的，客服端连接后自动解除阻塞状态
            Set<SelectionKey> set1 = selector.keys();
            Set<SelectionKey> set2 = selector.selectedKeys();
            System.out.println("keyCount = " + keyCount);
            System.out.println("set1 = " + set1.size());
            System.out.println("set2 = " + set2.size());
            System.out.println();

            Iterator<SelectionKey> iterator = set2.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                ServerSocketChannel channel = (ServerSocketChannel) key.channel();

                SocketChannel socketChannel = channel.accept();
                socketChannel.configureBlocking(false);

                SelectionKey key2 = socketChannel.register(selector, SelectionKey.OP_READ);
                System.out.println("key2.isReadable()=" + ((SelectionKey.OP_READ & ~key2.interestOps()) == 0));
                System.out.println("key2.isWritable()=" + ((SelectionKey.OP_WRITE & ~key2.interestOps()) == 0));


                SelectionKey key3 = socketChannel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                System.out.println("key3.isReadable()=" + ((SelectionKey.OP_READ & ~key3.interestOps()) == 0));
                System.out.println("key3.isWritable()=" + ((SelectionKey.OP_WRITE & ~key3.interestOps()) == 0));

                System.out.println("(key2 == key3) = " + (key2 == key3)); // 验证 相同的通道注册不同事件返回的selectionKey是同一个。


               // iterator.remove(); // 删除当前的SelectKey，避免重复消费问题
            }
            System.out.println();

        }
        serverSocketChannel1.close();
    }
}
