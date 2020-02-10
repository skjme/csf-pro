package nio.selector;

import java.net.Socket;

public class Test1_Client {

    public static void main(String[] args) throws Exception{

        for(int i = 0; i < 100; i++){
            Socket socket = new Socket("localhost", 8888);
            socket.close();
            System.out.println("客户端的连接个数为：" + (i+1));
        }
    }
}
