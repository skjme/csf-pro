package nio.socket.test10;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        StringBuffer buffer = new StringBuffer(1000000);
        for(int i = 0; i < 1000000; i++){
            buffer.append("1");
        }
        buffer.append("end");
        System.out.println("Server填充完毕");

        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        socket.setSendBufferSize(1000000);

        socket.setSoLinger(true, 10);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(buffer.toString().getBytes());

        long beginTime = 0;
        long endTime = 0;
        beginTime = System.currentTimeMillis();
        System.out.println("C:" +beginTime);


        endTime = System.currentTimeMillis();
        System.out.println("D:" + endTime);
        System.out.println("时间差：" + (endTime - beginTime));

        Thread.sleep(Integer.MAX_VALUE);

        socket.close();
        serverSocket.close();
    }
}
