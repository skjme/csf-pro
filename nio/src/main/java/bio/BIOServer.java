package bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String [] args) throws IOException {
        new BIOServer().server();
    }

    public void server() throws IOException {

        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("server start, port: 8000, awaiting for client connect....");

        while(true){
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            byte [] buffer = new byte[1024];
            int len = 0;
            //read client data
            while((len = inputStream.read(buffer)) > 0){
                System.out.println(new String(buffer, 0, len));
            }
            // send client data
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello everybody".getBytes());
        }

    }
}
