package nio.socket.socker_thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 结合多线程实现通信
 */
public class BeginServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        int runTag = 1;
        while (runTag == 1){
            Socket socket = serverSocket.accept();
            BeginThread beginThread = new BeginThread(socket);
            beginThread.start();
        }
        serverSocket.close();
    }
}
