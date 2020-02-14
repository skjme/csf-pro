package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test11Server {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
        serverSocketChannel.configureBlocking(false);

        // 验证selector.select()是阻塞的
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("---");

        boolean isRun = true;
        while (isRun){
            int keyCount = selector.select(); // 该方法是阻塞的，客服端连接后自动解除阻塞状态
            Set<SelectionKey> keys = selector.keys();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println(keyCount);
            System.out.println(keys.size());
            System.out.println(selectionKeys.size());
            System.out.println();

            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            while (selectionKeyIterator.hasNext()){
                SelectionKey key = selectionKeyIterator.next();
                ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                channel.accept(); //

                InetSocketAddress ipAddress = (InetSocketAddress)channel.getLocalAddress();
                System.out.println(ipAddress.getPort() + "被客户端连接了");

                selectionKeyIterator.remove(); // 删除当前的SelectKey，避免重复消费问题
            }
        }
        serverSocketChannel.close();
    }
}
