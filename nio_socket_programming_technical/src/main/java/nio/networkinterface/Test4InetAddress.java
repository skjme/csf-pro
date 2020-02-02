package nio.networkinterface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 获取IP地址
 */
public class Test4InetAddress {
    public static void main(String[] args) {
        try {

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("获取网络设备名称=" + networkInterface.getName());
                System.out.println("获取网络设备显示名称=" + networkInterface.getDisplayName());
                System.out.println("获取网卡的InetAddress信息：" );
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while(inetAddresses.hasMoreElements()){
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("获取此IP地址的完全限定域名 = " + inetAddress.getCanonicalHostName());
                    System.out.println("获取此IP地址的主机名 = " + inetAddress.getHostName());
                    System.out.println("获取此IP地址字符串 = " + inetAddress.getHostAddress());
                    System.out.print("原始IP地址 = " );
                    byte[] address = inetAddress.getAddress();
                    for(int i = 0; i < address.length; i++){
                        System.out.print(address[i] + " ");
                    }
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
