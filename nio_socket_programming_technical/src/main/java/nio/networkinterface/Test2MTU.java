package nio.networkinterface;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class Test2MTU {

    public static void main(String[] args) {
        try {

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("获取网络设备名称=" + networkInterface.getName());
                System.out.println("获取网络设备显示名称=" + networkInterface.getDisplayName());
                System.out.println("获取最大传输单元=" + networkInterface.getMTU());
                System.out.println();
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
