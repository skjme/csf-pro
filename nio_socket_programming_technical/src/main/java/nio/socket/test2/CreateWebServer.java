package nio.socket.test2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CreateWebServer {

    // 测试客户端，使用postman 访问localhost:6666
    public static void main(String[] args) throws IOException {

//        ServerSocket serverSocket = new ServerSocket( 6666);
//        ➜  ~ lsof -i:6666
//        COMMAND   PID   USER   FD   TYPE             DEVICE SIZE/OFF NODE NAME
//        java    24939 ask123   25u  IPv6 0xfa11dbe44c256983      0t0  TCP *:6666 (LISTEN)
//

        InetAddress bindAddress = InetAddress.getLocalHost();
        ServerSocket serverSocket = new ServerSocket( 6666, 1, bindAddress);
//        ➜  ~ lsof -i:6666
//        COMMAND   PID   USER   FD   TYPE             DEVICE SIZE/OFF NODE NAME
//        java    25102 ask123   26u  IPv6 0xfa11dbe44c256363      0t0  TCP localhost:6666 (LISTEN)


        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String getString = "";
        while(!"".equals(getString = bufferedReader.readLine()) && getString!=null){
            System.out.println(getString);
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        outputStream.write(
                "<HTML><BODY><a 'http://www.baidu.com'>i am baidu.com welcome you!</a></BODY></HTML>".getBytes());
        outputStream.flush();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();

    }
}
