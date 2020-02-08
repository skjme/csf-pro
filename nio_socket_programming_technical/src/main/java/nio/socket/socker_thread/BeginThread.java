package nio.socket.socker_thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class BeginThread extends Thread {

    private Socket socket;

    BeginThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try{

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char [] charArray = new char[1000];
            int readLength = -1;
            while( (readLength = inputStreamReader.read(charArray)) != -1){
                String newString = new String(charArray, 0, readLength);
                System.out.println(newString);
            }
            inputStreamReader.close();
            inputStream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
