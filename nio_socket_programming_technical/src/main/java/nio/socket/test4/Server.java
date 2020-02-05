package nio.socket.test4;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    /**
     * 服务器接受客户端传递字符串
     * @param args
     */
    public static void main(String[] args) {

        try{

            char[] charArray = new char[3];
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("accept begin:" + System.currentTimeMillis());
            Socket socket = serverSocket.accept();// 呈阻塞效果
            System.out.println("accept end:" + System.currentTimeMillis());

            // 读取客户端发来的消息
//            InputStream inputStream = socket.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            System.out.println("read begin:" + System.currentTimeMillis());
//            int readLength = inputStreamReader.read(charArray); // 呈阻塞效果
//            while (readLength != -1){
//                String newString = new String(charArray, 0, readLength);
//                System.out.print(newString);
//                readLength = inputStreamReader.read(charArray);
//            }
//            System.out.println("read end:" + System.currentTimeMillis());

            // 服务器端向客户端发送字符串, 可以多次write
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是外星人, 来自服务器端".getBytes());
            Thread.sleep(1000);
            outputStream.write("我是外星人, 来自服务器端".getBytes());
             Thread.sleep(2000);
            outputStream.write("我是外星人, 来自服务器端".getBytes());
             Thread.sleep(4000);
            outputStream.write("我是外星人, 来自服务器端".getBytes());


            outputStream.close();
//            inputStreamReader.close();
//            inputStream.close();
            socket.close();
            serverSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
