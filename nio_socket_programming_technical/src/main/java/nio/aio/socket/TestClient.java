package nio.aio.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我来自客户端".getBytes());
        outputStream.flush();
        socket.close();
    }
}
