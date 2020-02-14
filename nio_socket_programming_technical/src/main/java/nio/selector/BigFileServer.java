package nio.selector;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class BigFileServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
//        channel.bind(new InetSocketAddress("localhost", 8088));
        channel.bind(new InetSocketAddress("192.168.1.148", 8088));

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;
        while(isRun == true){
            selector.select();
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if(key.isAcceptable()){
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                }

                if (key.isWritable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    FileInputStream fileInputStream  = new FileInputStream("/Users/ask123/Desktop/a.txt");
                    FileChannel fileChannel = fileInputStream.getChannel();
                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(524288000);// 500M
                    while (fileChannel.position() < fileChannel.size()){
                        fileChannel.read(byteBuffer);
                        byteBuffer.flip();
                        while (byteBuffer.hasRemaining()){
                            socketChannel.write(byteBuffer);
                        }
                        byteBuffer.clear();
                        System.out.println(fileChannel.position() + " " + fileChannel.size());
                    }
                    System.out.println("结束写操作");
                    socketChannel.close();
                }
            }

            channel.close();

        }
    }
}
