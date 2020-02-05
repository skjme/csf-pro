package nio.socket.doubleSayString;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class Client {

    public static void main(String[] args) {

        try{

            Socket clientSockent = new Socket("localhost", 8088);
            OutputStream outputStream = clientSockent.getOutputStream();
            InputStream inputStream = clientSockent.getInputStream();

            // 输出开始
            String strA = "服务器你好A\n";
            String strB = "服务器你好B\n";
            String strC = "服务器你好C\n";
            int allStrByteLength = (strA + strB + strC).getBytes().length;
            System.out.println("allStrByteLength=" + allStrByteLength);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.write(allStrByteLength);
            objectOutputStream.flush();
            objectOutputStream.write(strA.getBytes());
            objectOutputStream.write(strB.getBytes());
            objectOutputStream.write(strC.getBytes());
            objectOutputStream.flush();
            // 输出结束


            // 输入开始，读取服务器信息
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            int byteLength = objectInputStream.readInt();
            byte[] byteArray = new byte[byteLength];
            objectInputStream.readFully(byteArray);
            String newString = new String(byteArray);
            System.out.println(newString);
            // 输入结束



            // 输出开始 服务器端向服务器发送字符串, 可以多次write
            strA = "服务器你好D\n";
            strB = "服务器你好E\n";
            strC = "服务器你好F\n";
            allStrByteLength = (strA + strB + strC).getBytes().length;
            objectOutputStream.write(allStrByteLength);
            objectOutputStream.flush();
            objectOutputStream.write(strA.getBytes());
            objectOutputStream.write(strB.getBytes());
            objectOutputStream.write(strC.getBytes());
            objectOutputStream.flush();
            // 输出结束

            // 输入开始，读取服务器信息
            byteLength = objectInputStream.readInt();
            byteArray = new byte[byteLength];
            objectInputStream.readFully(byteArray);
            newString = new String(byteArray);
            System.out.println(newString);
            // 输入结束


            objectOutputStream.close();
            outputStream.close();
            clientSockent.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
