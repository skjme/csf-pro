package nio.socket.udpSendBigData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(8888);

        byte[] bytes = new byte[65507];
//        byte[] bytes = new byte[60000];
//        DatagramPacket packet = new DatagramPacket(bytes, 60000);
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        serverSocket.receive(packet);
        serverSocket.close();
        System.out.println("包中数据的长度：" + packet.getLength());
        String newString = new String(packet.getData(), 0, packet.getLength());

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/ask123/Desktop/a.txt");
        fileOutputStream.write(newString.getBytes());
        fileOutputStream.close();
    }
}
