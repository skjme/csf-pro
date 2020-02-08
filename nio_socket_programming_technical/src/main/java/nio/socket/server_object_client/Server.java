package nio.socket.server_object_client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // 服务器与客户端获取对象流顺序必须不一致，否则会堵塞
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        for(int i = 0; i < 5; i++){
            Userinfo userinfo = (Userinfo) objectInputStream.readObject();
            System.out.println("在服务器端打印" + (i+1) + ":" + userinfo.getId()
                    + " " + userinfo.getUsername()
                    + " " + userinfo.getPassword());

            Userinfo newUserInfo = new Userinfo();
            newUserInfo.setId(i+1);
            newUserInfo.setUsername("serverUsername"+(i+1));
            newUserInfo.setPassword("serverPassword"+(i+1));

            objectOutputStream.writeObject(newUserInfo);

        }

        objectOutputStream.close();
        objectInputStream.close();

        outputStream.close();
        inputStream.close();

        socket.close();
        serverSocket.close();
    }
}
