package nio.socket.test1;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8088);
        System.out.println("server阻塞开始=" + System.currentTimeMillis());
        serverSocket.accept();
        System.out.println("server阻塞结束=" + System.currentTimeMillis());
        serverSocket.close();;
    }
}
