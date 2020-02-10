package nio.socket.udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(8888);

        byte[] bytes = new byte[12];
        DatagramPacket packet = new DatagramPacket(bytes, 10);

        serverSocket.receive(packet);
        serverSocket.close();
        System.out.println("包中数据的长度：" + packet.getLength());
        String newString = new String(packet.getData(), 0, packet.getLength());
        System.out.println(newString);
    }
}
