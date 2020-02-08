package nio.socket.socker_thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReadRunable implements Runnable {

    private Socket socket;

    ReadRunable(Socket socket){
        super();
        this.socket = socket;
    }

    @Override
    public void run() {

        try{
            InputStream inputStream = socket.getInputStream();
            byte[] byteArray = new byte[100];
            int readLength = inputStream.read(byteArray);
            while(readLength != -1){
                String newString = new String(byteArray, 0, readLength);
                System.out.println(newString);
                readLength = inputStream.read(byteArray);
            }
            inputStream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
