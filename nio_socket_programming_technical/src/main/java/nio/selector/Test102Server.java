package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test102Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
        serverSocketChannel1.bind(new InetSocketAddress("localhost",7777));
        serverSocketChannel1.configureBlocking(false);

        ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
        serverSocketChannel2.bind(new InetSocketAddress("localhost",8888));
        serverSocketChannel2.configureBlocking(false);

        ServerSocketChannel serverSocketChannel3 = ServerSocketChannel.open();
        serverSocketChannel3.bind(new InetSocketAddress("localhost",9999));
        serverSocketChannel3.configureBlocking(false);

        // 验证selector.select()是阻塞的
        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey selectionKey2 = serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey selectionKey3 = serverSocketChannel3.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("-------------");

        boolean isRun = true;
        while (isRun){
            int keyCount = selector.select(); // 该方法是阻塞的，客服端连接后自动解除阻塞状态
            Set<SelectionKey> set1 = selector.keys();
            Set<SelectionKey> set2 = selector.selectedKeys();
            System.out.println("keyCount = " + keyCount);
            System.out.println("set1 = " + set1.size());
            System.out.println("set2 = " + set2.size());
//            System.out.println();

            Iterator<SelectionKey> iterator = set2.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                channel.accept(); //

                InetSocketAddress ipAddress = (InetSocketAddress)channel.getLocalAddress();
                System.out.println(ipAddress.getPort() + "被客户端连接了");
                System.out.println("-------");

                iterator.remove(); // 删除当前的SelectKey，避免重复消费问题
            }

            Thread.sleep(10000);
        }
        serverSocketChannel1.close();
        serverSocketChannel2.close();
        serverSocketChannel3.close();
    }
}
