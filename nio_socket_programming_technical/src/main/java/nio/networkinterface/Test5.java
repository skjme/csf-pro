package nio.networkinterface;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test5 {

    public static void main(String[] args) throws UnknownHostException {

        // 1.获取本地主机
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println(localhost);

        byte[] localhostIPAddress = localhost.getAddress();
        for(int i = 0; i < localhostIPAddress.length; i++){
            System.out.print(" " + localhostIPAddress[i] + " ");
        }
        System.out.println();
        System.out.println(localhost.getClass().getName());


        // 2.获取回调（回环）地址
        System.out.println();
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println(loopbackAddress);
        byte[] loopbackIPAddress = loopbackAddress.getAddress();
        for(int i = 0; i < loopbackIPAddress.length; i++){
            System.out.print(" " + loopbackIPAddress[i] + " ");
        }
        System.out.println();
        System.out.println(loopbackAddress.getClass().getName());
        System.out.println();

        // 3 根据主机名获取IP
        InetAddress myAddress = InetAddress.getByName("MacPro.local"); // 计算机名
        InetAddress baiduAddress = InetAddress.getByName("www.baidu.com"); // 域名

        InetAddress ipStringAddress = InetAddress.getByName("192.168.1.48"); // IP地址
        InetAddress localhostAddress = InetAddress.getByName("localhost");

        System.out.println(myAddress.getClass().getName() + " " + myAddress.getHostAddress());
        System.out.println(baiduAddress.getClass().getName() + " " + baiduAddress.getHostAddress());
        System.out.println(ipStringAddress.getClass().getName() + " " + ipStringAddress.getHostAddress());
        System.out.println(localhostAddress.getClass().getName() + " " + localhostAddress.getHostAddress());

        // 错误IP地址
        try{
            InetAddress.getByName("192.168.1.777");
        }catch (UnknownHostException e){
            e.printStackTrace();
        }

        // 错误域名
//        try{
//            InetAddress.getByName("www.baibai.com");
//        }catch (UnknownHostException e){
//            e.printStackTrace();
//        }


        // 4 根据主机名获取所有IP地址
        InetAddress[] myAddressArray = InetAddress.getAllByName("MacPro.local");
        System.out.println(myAddressArray.length);
        for (int i = 0; i < myAddressArray.length; i++){
            InetAddress address = myAddressArray[i];
            System.out.println(address.getClass().getName() + " " + address.getHostAddress());

        }

        InetAddress[] baiduAddressArray = InetAddress.getAllByName("www.baidu.com");
        System.out.println(baiduAddressArray.length);
        for (int i = 0; i < baiduAddressArray.length; i++){
            InetAddress baiduIpAddress = baiduAddressArray[i];
            System.out.println(baiduIpAddress.getClass().getName() + " " + baiduIpAddress.getHostAddress());

        }

        InetAddress[] ipStringAddressArray = InetAddress.getAllByName("192.168.1.48");
        System.out.println(ipStringAddressArray.length);
        for (int i = 0; i < ipStringAddressArray.length; i++){
            InetAddress ipStringAddress1 = ipStringAddressArray[i];
            System.out.println(ipStringAddress1.getClass().getName() + " " + ipStringAddress1.getHostAddress());
        }

        System.out.println();

        // 5 根据主机名、IP地址byte[]addr获得InetAddress对象
        byte[] byteArray = new byte[]{-64, -88, 0, 102}; // 对应IP192.168.0,102
//        InetAddress byAddress = InetAddress.getByAddress(byteArray);
        InetAddress byAddress = InetAddress.getByAddress("www.zzz.cn", byteArray);
        System.out.println(byAddress.getHostAddress());
        System.out.println(byAddress.getHostName());
        System.out.println(byAddress.getClass().getName());
        System.out.println();

        // 6 获取全限主机名和主机名
//        InetAddress inetAddress = InetAddress.getLocalHost();
//        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        InetAddress inetAddress = InetAddress.getByName("182.61.200.7");
        System.out.println(inetAddress.getCanonicalHostName());
        System.out.println(inetAddress.getHostName());
    }
}
