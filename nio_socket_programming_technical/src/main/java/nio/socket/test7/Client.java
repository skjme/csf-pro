package nio.socket.test7;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {

            for(int i = 0; i < 100; i++){
//                Thread.sleep(1000);
                System.out.println("client request begin:" + System.currentTimeMillis() + " " + (i+1));
                Socket socket1 = new Socket("localhost", 8000);
                System.out.println("client request end:" + System.currentTimeMillis() + " " + (i+1));
                System.out.println();
            }
//            Socket socket1 = new Socket("localhost", 8000);
//            Socket socket2 = new Socket("localhost", 8000);
//            Socket socket3 = new Socket("localhost", 8000);
//            Socket socket4 = new Socket("localhost", 8000);
//            Socket socket5 = new Socket("localhost", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
