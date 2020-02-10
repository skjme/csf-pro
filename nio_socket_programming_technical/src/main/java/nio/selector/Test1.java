package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test1 {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);// 设置为非阻塞
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress("localhost", 8888));

        System.out.println(serverSocketChannel.isRegistered());

        Selector selector = Selector.open();
        System.out.println(selector); // mac os output:sun.nio.ch.KQueueSelectorImpl@61bbe9ba
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(selectionKey);

        System.out.println(serverSocketChannel.isRegistered());

        serverSocket.close();
        serverSocketChannel.close();

    }
}
