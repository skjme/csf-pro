package nio.selector.selectionKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test1_2 {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_CONNECT);
        boolean isRun = true;
        socketChannel.connect(new InetSocketAddress("localhost", 8888));
        while (isRun){
            int keyCount = selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isConnectable()){
                    System.out.println("client isConnectable");
                    if(socketChannel.isConnectionPending()){
                        while(!socketChannel.finishConnect()){
                            System.out.println("!socketChannel.finishConnect()");
                        }
                        socketChannel.register(selector, selectionKey.OP_WRITE, "我使用附件进行注册，我来自客户端，你好服务器！");
                        key.attach("我覆盖了哦");
                    }
//                    SocketChannel channel = (SocketChannel) key.channel();
//                    byte[] writeData = "我来自客户端，你好，服务器！".getBytes();
//                    ByteBuffer byteBuffer = ByteBuffer.wrap(writeData);
//                    channel.write(byteBuffer);
//
//                    channel.close();
                }
                if(key.isWritable()){
                    System.out.println("client isWritable");
                    ByteBuffer byteBuffer = ByteBuffer.wrap(((String)key.attachment()).getBytes());
                    socketChannel.write(byteBuffer);
                    socketChannel.close();
                }
                iterator.remove();
            }
        }
        socketChannel.close();
        System.out.println("client end!");
    }
}
