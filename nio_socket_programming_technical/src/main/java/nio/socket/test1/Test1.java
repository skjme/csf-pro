package nio.socket.test1;

import java.io.IOException;
import java.net.Socket;

public class Test1 {

    public static void main(String[] args) throws IOException {

        Socket socket = null; // 创建客户端socket
        try{

            socket = new Socket("www.csdn.net", 80);
            System.out.println("socket连接成功");
            socket.close();
        }catch (IOException ex){
            System.out.println("socket连接失败");
            ex.printStackTrace();
        }finally {
            socket.close();
        }

    }
}
