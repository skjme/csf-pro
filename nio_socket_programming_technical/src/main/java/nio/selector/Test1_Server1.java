package nio.selector;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class Test1_Server1 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 使用serverSocket进行bind
//        ServerSocket serverSocket = serverSocketChannel.socket();
//        serverSocket.bind(new InetSocketAddress("localhost", 8888));

        // 使用serverSocketChannel进行bind
//        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888), 60);
        ServerSocket serverSocket = serverSocketChannel.socket();

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char [] charArray = new char[1024];
        int readLength = inputStreamReader.read(charArray);
        while (readLength != -1){
            String newString = new String(charArray, 0, readLength);
            System.out.println(newString);
            readLength = inputStreamReader.read(charArray);
        }
        inputStreamReader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        serverSocketChannel.close();

    }
}
