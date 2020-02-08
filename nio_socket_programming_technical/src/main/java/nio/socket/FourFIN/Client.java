package nio.socket.FourFIN;

import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try{

            System.out.println("client连接准备" + System.currentTimeMillis());
            Socket socket = new Socket("localhost", 8088);
            System.out.println("client连接结束" + System.currentTimeMillis());

            OutputStream outputStream = socket.getOutputStream();
            for(int i = 0 ; i < 3; i++){
                outputStream.write("1234567890".getBytes());
                System.out.println(i+1);
            }
            outputStream.close();

            socket.close();
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
