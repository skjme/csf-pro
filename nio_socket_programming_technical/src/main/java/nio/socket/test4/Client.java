package nio.socket.test4;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("socket begin:" + System.currentTimeMillis());
            Socket socket = new Socket("localhost", 8088);
            System.out.println("socket end:" + System.currentTimeMillis());
            Thread.sleep(3000);

            // 客户端向服务端发送字符串
//            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write("我是外星人".getBytes());

            // 读取服务器端信息
            char[] charArray = new char[3];
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            System.out.println("read begin:" + System.currentTimeMillis());
            int readLength = inputStreamReader.read(charArray); // 呈阻塞效果
            while (readLength != -1){
                String newString = new String(charArray, 0, readLength);
                System.out.print(newString);
                readLength = inputStreamReader.read(charArray);
            }
            System.out.println();
            System.out.println("read end:" + System.currentTimeMillis());

            inputStream.close();
//            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
