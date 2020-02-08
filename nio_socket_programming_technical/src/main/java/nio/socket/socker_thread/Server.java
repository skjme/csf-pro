package nio.socket.socker_thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 使用线程池
 */
public class Server {

    private ServerSocket serverSocket;
    private Executor pool;

    public Server(int port, int poolSize){
        try{
            serverSocket = new ServerSocket(port);
            pool = Executors.newFixedThreadPool(poolSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void startService(){
        try{
            for (;;){
                Socket socket = serverSocket.accept();
                pool.execute(new ReadRunable(socket));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Server server = new Server(8088, 10000);
        server.startService();
    }
}
