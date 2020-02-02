package nio.networkinterface;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class Test1NetworkInterface {

    public static void main(String[] args) {
        try {

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("获取网络设备名称=" + networkInterface.getName());
                System.out.println("获取网络设备显示名称=" + networkInterface.getDisplayName());
                System.out.println("获取网络接口的索引=" + networkInterface.getIndex());
                System.out.println("是否已经开启并运行=" + networkInterface.isUp());
                System.out.println("是否为回调接口=" + networkInterface.isLoopback());
                System.out.println();
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
