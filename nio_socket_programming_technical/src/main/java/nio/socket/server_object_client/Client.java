package nio.socket.server_object_client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8888);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // 服务器与客户端获取对象流顺序必须不一致，否则会堵塞
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        for(int i = 0; i < 5; i++){

            Userinfo newUserInfo = new Userinfo();
            newUserInfo.setId(i+1);
            newUserInfo.setUsername("clientUsername"+(i+1));
            newUserInfo.setPassword("clientPassword"+(i+1));

            objectOutputStream.writeObject(newUserInfo);

            Userinfo userinfo = (Userinfo) objectInputStream.readObject();
            System.out.println("在客户端打印" + (i+1) + ":" + userinfo.getId()
                    + " " + userinfo.getUsername()
                    + " " + userinfo.getPassword());


        }

        objectOutputStream.close();
        objectInputStream.close();

        outputStream.close();
        inputStream.close();

        socket.close();
    }
}
