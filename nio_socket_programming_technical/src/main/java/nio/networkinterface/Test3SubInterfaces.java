package nio.networkinterface;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class Test3SubInterfaces {

    public static void main(String[] args) {
        try {

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("获取网络设备名称=" + networkInterface.getName());
                System.out.println("获取网络设备显示名称=" + networkInterface.getDisplayName());
                System.out.println("是否为虚拟接口=" + networkInterface.isVirtual());
                System.out.println("获取父接口=" + networkInterface.getParent());
                System.out.println("获取子接口:");

                Enumeration<NetworkInterface> subInterfaces = networkInterface.getSubInterfaces();
                while(subInterfaces.hasMoreElements()){
                    NetworkInterface eachNetworkIntefaceSub = subInterfaces.nextElement();
                    System.out.println("获取网络设备名称=" + eachNetworkIntefaceSub.getName());
                    System.out.println("获取网络设备显示名称=" + eachNetworkIntefaceSub.getDisplayName());
                    System.out.println("是否为虚拟接口=" + eachNetworkIntefaceSub.isVirtual());
                    System.out.println("获取父接口hashCode=" + eachNetworkIntefaceSub.getParent().hashCode());
                    System.out.println();
                    System.out.println();
                }


                System.out.println();
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
