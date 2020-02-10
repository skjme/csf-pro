package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest1 {

    public static void main(String[] args) {

        long beginTime = 0;
        long endTime = 0;

        boolean connectResult = false;
        try {
            SocketChannel socketChannel = SocketChannel.open();
            System.out.println(socketChannel.isBlocking());
//            socketChannel.configureBlocking(false);
//            System.out.println(socketChannel.isBlocking());
            System.out.println(socketChannel.isConnected());
            beginTime = System.currentTimeMillis();
            connectResult = socketChannel.connect(new InetSocketAddress("localhost", 8888));
            endTime = System.currentTimeMillis();
            System.out.println("正常连接耗时：" + (endTime - beginTime) + " connect-Result=" + connectResult);
            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
            endTime = System.currentTimeMillis();
            System.out.println("异常连接耗时：" + (endTime - beginTime) + " connect-Result=" + connectResult);
        }

    }
}
