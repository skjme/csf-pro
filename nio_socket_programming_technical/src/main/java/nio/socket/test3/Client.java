package nio.socket.test3;

import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("socket begin:" + System.currentTimeMillis());
            Socket socket = new Socket("localhost", 8088);
            System.out.println("socket end:" + System.currentTimeMillis());
            Thread.sleep(Integer.MAX_VALUE);
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
