package nio.socket.FourFIN;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // 测试Tcp断开连接的4次"挥手"过程
    public static void main(String[] args) {
        try{

            ServerSocket serverSocket = new ServerSocket(8088);
            Thread.sleep(Integer.MAX_VALUE);

            System.out.println("server阻塞开始" + System.currentTimeMillis());
            Socket socket = serverSocket.accept();
            System.out.println("server阻塞结束" + System.currentTimeMillis());
            socket.close();
            serverSocket.close();
            Thread.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
