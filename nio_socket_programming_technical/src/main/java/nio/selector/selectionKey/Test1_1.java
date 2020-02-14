package nio.selector.selectionKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test1_1 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
        serverSocketChannel1.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel1.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println(selector);
        System.out.println(selectionKey.selector());
        System.out.println(selectionKey.isValid());
//        selectionKey.cancel();
//        System.out.println(selectionKey.isValid());

        boolean isRun = true;
        SocketChannel socketChannel = null;

        while (isRun){
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                if(key.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                    System.out.println("server isAcceptable");
                    socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if(key.isReadable()){
                    System.out.println("Server isReadable");
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
                    int readLength = socketChannel.read(byteBuffer);
                    while(readLength!=-1){
                        System.out.println(new String(byteBuffer.array(), 0, readLength));
                        readLength = socketChannel.read(byteBuffer);
                    }
                   socketChannel.close();
                }
                iterator.remove();
            }
        }
        serverSocketChannel1.close();

    }
}
