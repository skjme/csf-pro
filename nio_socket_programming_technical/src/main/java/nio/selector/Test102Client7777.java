package nio.selector;

import java.io.IOException;
import java.net.Socket;

public class Test102Client7777 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 7777);
        socket.close();
    }
}
