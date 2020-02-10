package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest2 {

    public static void main(String[] args) throws IOException {

        long beginTime = 0;
        long endTime = 0;

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        System.out.println(socketChannel.isBlocking());

        boolean connectResult = socketChannel.connect(new InetSocketAddress("localhost", 8888));

       if(connectResult == false){
           System.out.println("connectResult is " + connectResult);
           System.out.println(socketChannel.finishConnect());
           while (!socketChannel.finishConnect()){
               System.out.println("一直在尝试连接");
           }
       }

       socketChannel.close();

    }
}
