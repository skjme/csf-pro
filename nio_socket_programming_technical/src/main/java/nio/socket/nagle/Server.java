package nio.socket.nagle;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("A=" + socket.getTcpNoDelay());
        socket.setTcpNoDelay(false); // 开启数据缓存
        System.out.println("B=" + socket.getTcpNoDelay());
        OutputStream outputStream = socket.getOutputStream();
        for (int i = 1; i < 50000; i++){
            outputStream.write("1".getBytes());
        }
        socket.close();
        serverSocket.close();
    }
}
