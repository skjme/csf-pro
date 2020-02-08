package nio.socket.ServerSocketReuseAddress_server;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Thread server = new Thread(){
            @Override
            public void run() {

                try{
                    ServerSocket serverSocket = new ServerSocket();
                    serverSocket.setReuseAddress(false);
                    serverSocket.bind(new InetSocketAddress("localhost", 8888));
//                    Thread.sleep(2000);
                    Socket socket = serverSocket.accept();
                    System.out.println("server port:" + socket.getLocalPort());
                    System.out.println("client port:" + socket.getPort());

                    InputStream inputStream = socket.getInputStream();
                    byte[] byteArray = new byte[4];
                    int readLength = inputStream.read(byteArray);
                    System.out.println(new String(byteArray, 0, readLength));

                    System.out.println(inputStream.available());
                     readLength = inputStream.read(byteArray); // output:-1
                    System.out.println(readLength);

                    socket.getOutputStream(); // throws



                    Thread.sleep(1000);
                    socket.close();
                    serverSocket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        server.start();

        Thread.sleep(500);

        Thread client = new Thread(){
            @Override
            public void run() {
                try{
//                    Socket socket = new Socket("localhost", 8888);
                    Socket socket = new Socket();
                    socket.bind(new InetSocketAddress("localhost", 7777));
                    socket.connect(new InetSocketAddress("localhost", 8888), 1000);
                    Thread.sleep(5000);

                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("123".getBytes());
                    outputStream.flush();

                    socket.shutdownOutput();
                    socket.getOutputStream();

                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        client.start();
    }
}
