package nio.socket.udpSendBigData;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client {

    // 数据量大于65507，则发生异常
    public static void main(String[] args) throws SocketException {
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.connect(new InetSocketAddress("localhost", 8888));
        String newString = "";
        for(int i = 0; i < 65507 -3; i++){
//        for(int i = 0; i < 60000; i++){
            newString = newString + "a";
        }
        newString = newString +"end";
//        newString = newString +"zz";
        byte[]bytes = newString.getBytes();
        DatagramPacket myPacket = new DatagramPacket(bytes, bytes.length);
        try {
            clientSocket.send(myPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientSocket.close();

    }
}
