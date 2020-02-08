package nio.socket.nagle;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8888);
        socket.setTcpNoDelay(false);
        InputStream inputStream = socket.getInputStream();

        long startTime = System.currentTimeMillis();
        byte[] byteArray = new byte[1];
        int readLength = inputStream.read(byteArray);
        while(readLength != -1){
            String newString = new String(byteArray, 0, readLength);
            System.out.println(newString);
            readLength = inputStream.read(byteArray);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("take time:" + (endTime - startTime));

        socket.close();

    }
}
