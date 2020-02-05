package nio.socket.test1;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args){

        try{
            System.out.println("client连接准备=" + System.currentTimeMillis());
            Socket clientSocket = new Socket("localhost", 8088);
            System.out.println("client连接结束=" + System.currentTimeMillis());
            clientSocket.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
