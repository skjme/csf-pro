package nio.socket.test7;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws InterruptedException {
        try {
//            ServerSocket serverSocket = new ServerSocket(8000);
//            ServerSocket serverSocket = new ServerSocket(0, 0);
//            ServerSocket serverSocket = new ServerSocket(8000, 0);
            ServerSocket serverSocket = new ServerSocket();
//            serverSocket.bind(new InetSocketAddress(8000));
//            serverSocket.bind(new InetSocketAddress(8000), Integer.MAX_VALUE);
            serverSocket.bind(new InetSocketAddress(8000), 1);
            Thread.sleep(5000);

//            System.out.println(serverSocket.getSoTimeout());
//            serverSocket.setSoTimeout(4000); // 设置4s超时
//            System.out.println(serverSocket.getSoTimeout());
//            System.out.println();

            for(int i = 0; i < 100; i++){
                System.out.println("accept begin:" + System.currentTimeMillis() + " " + (i+1));
                Socket socket1 = serverSocket.accept();
                System.out.println("accept end:" + System.currentTimeMillis() + " " + (i+1));
                System.out.println();

            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("cacth:" + System.currentTimeMillis());
        }
    }
}
