package nio.socket.beginTransFile;


import java.io.*;
import java.net.Socket;

/**
 * 上传图片
 */
public class FileClient {

    // input -> 内存
    // output -> 终端
    public static void main(String[] args) {

        try{

            String pngFile = "/Users/ask123/Desktop/qq.png";
            FileInputStream pngInputStream = new FileInputStream(new File(pngFile));
            byte[] byteArray = new byte[2048];

            System.out.println("sockect begin:" + System.currentTimeMillis());
            Socket socket = new Socket("localhost", 8088);
            System.out.println("sockect end:" + System.currentTimeMillis());

            OutputStream outputStream = socket.getOutputStream();

            int readLength = pngInputStream.read(byteArray);
            while(readLength != -1){
                outputStream.write(byteArray, 0, readLength);
                readLength = pngInputStream.read(byteArray);
            }

            outputStream.close();
            pngInputStream.close();
            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
