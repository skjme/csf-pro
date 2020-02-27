package javase.rmi.cli;

import javase.rmi.WorldClock;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        // 连接到服务器
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);

        // 查找服务"WorldClock",并强制转为WorldClock服务
        WorldClock worldClock = (WorldClock)registry.lookup("WorldClock");

        // 正常调用接口方法
        LocalDateTime now = worldClock.getLocalDateTime("Asia/Shanghai");
        System.out.println(now);
    }
}
