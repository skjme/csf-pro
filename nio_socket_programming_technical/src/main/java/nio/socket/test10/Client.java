package nio.socket.test10;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("localhost", 8888);
        InputStream inputStream = socket.getInputStream();
        byte[] byteArray = new byte[1];
        int readLength = inputStream.read(byteArray);
        while (readLength != -1){
            String newString = new String(byteArray, 0, readLength);
            System.out.println(newString);
            readLength = inputStream.read(byteArray);
        }
        System.out.println("E=" + System.currentTimeMillis());
        inputStream.close();

        Thread.sleep(Integer.MAX_VALUE);

        socket.close();

    }
}
