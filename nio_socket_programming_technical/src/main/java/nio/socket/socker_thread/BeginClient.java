package nio.socket.socker_thread;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class BeginClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8088);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是中国人".getBytes());
        outputStream.close();
        socket.close();
    }
}
