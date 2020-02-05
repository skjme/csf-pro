package nio.socket.beginTransFile;

import javax.naming.ldap.SortKey;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 上传图片
 */
public class FileServer {

    public static void main(String[] args) {

        try{

            byte[] byteArray = new byte[2048];
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            int readLength = inputStream.read(byteArray);

            FileOutputStream pngOutputStream = new FileOutputStream(new File("/Users/ask123/Desktop/newqq.png"));

            while(readLength != -1){
                pngOutputStream.write(byteArray, 0, readLength);
                readLength = inputStream.read(byteArray);
            }

            pngOutputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
