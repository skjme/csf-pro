package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test11 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
        serverSocketChannel.configureBlocking(false);

        // 验证selector.select()是阻塞的
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("---");
        int select = selector.select(); // 是阻塞的，连接到client后就阻塞状态就消失
        System.out.println("client运行后，立刻打印：" + select);
        serverSocketChannel.close();
    }
}
