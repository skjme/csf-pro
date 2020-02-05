package nio.socket.doubleSayString;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try{

            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();// 呈阻塞效果

            // 输入开始，读取客户端信息
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            int byteLength = objectInputStream.readInt();
            System.out.println("byteLength=" + byteLength);
            byte[] byteArray = new byte[byteLength];
            objectInputStream.readFully(byteArray);
            String newString = new String(byteArray);
            System.out.println(newString);
            // 输入结束

            // 输出开始 服务器端向客户端发送字符串, 可以多次write
            OutputStream outputStream = socket.getOutputStream();
            String strA = "客户端你好A\n";
            String strB = "客户端你好B\n";
            String strC = "客户端你好C\n";
            int allStrByteLength = (strA + strB + strC).getBytes().length;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.write(allStrByteLength);
            objectOutputStream.flush();

            objectOutputStream.write(strA.getBytes());
            objectOutputStream.write(strB.getBytes());
            objectOutputStream.write(strC.getBytes());
            // 输出结束

            // 输入开始，读取客户端信息
            byteLength = objectInputStream.readInt();
            byteArray = new byte[byteLength];
            objectInputStream.readFully(byteArray);
            newString = new String(byteArray);
            System.out.println(newString);
            // 输入结束

            // 输出开始 服务器端向客户端发送字符串, 可以多次write
            strA = "客户端你好D\n";
            strB = "客户端你好E\n";
            strC = "客户端你好F\n";
            allStrByteLength = (strA + strB + strC).getBytes().length;
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.write(allStrByteLength);
            objectOutputStream.flush();

            objectOutputStream.write(strA.getBytes());
            objectOutputStream.write(strB.getBytes());
            objectOutputStream.write(strC.getBytes());
            // 输出结束


            inputStream.close();
            socket.close();
            serverSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
