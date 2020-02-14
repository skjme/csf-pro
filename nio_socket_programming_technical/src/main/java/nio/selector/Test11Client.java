package nio.selector;

import java.io.IOException;
import java.net.Socket;

public class Test11Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        socket.close();
    }
}
