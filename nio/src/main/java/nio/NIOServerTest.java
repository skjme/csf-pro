package nio;

import java.io.IOException;

public class NIOServerTest {

    public static void main(String [] args) throws IOException {
        NIOServer server = new NIOServer();
        server.initServer(8000);
        server.listen();
    }
}
