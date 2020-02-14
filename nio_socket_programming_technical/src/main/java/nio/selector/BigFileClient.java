package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class BigFileClient {

    public static void main(String[] args) throws IOException {

        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
//        channel.connect(new InetSocketAddress("localhost", 8088));
        channel.connect(new InetSocketAddress("192.168.1.148", 8088));

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_CONNECT);
        boolean isRun = true;
        while(isRun == true){
            System.out.println("begin selector");
            if(channel.isOpen() == true){
                selector.select();
                System.out.println("end selector");

                Set<SelectionKey> set = selector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if(key.isConnectable()){
                        while (!channel.finishConnect()){

                        }
                        channel.register(selector, SelectionKey.OP_READ);
                    }

                    if (key.isReadable()){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(50000);
                        int readLength = channel.read(byteBuffer);
                        byteBuffer.flip();
                        long count = 0;
                        while (readLength != -1){
                            count = count + readLength;
                            System.out.println("count=" + count + " readLength=" + readLength);
                            readLength = channel.read(byteBuffer);
                            byteBuffer.clear();
                        }

                        System.out.println("结束读操作");
                        channel.close();
                    }
                }
            }else{
                break;
            }
        }
    }
}
