package nio.socket.test3;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try{

            byte[] byteArray = new byte[1024];
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("accept begin:" + System.currentTimeMillis());
            Socket socket = serverSocket.accept();// 呈阻塞效果
            System.out.println("accept end:" + System.currentTimeMillis());

            InputStream inputStream = socket.getInputStream();
            System.out.println("read begin:" + System.currentTimeMillis());
            int readLength = inputStream.read(byteArray); // 呈阻塞效果
            System.out.println("read end:" + System.currentTimeMillis());

            inputStream.close();
            socket.close();
            serverSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
