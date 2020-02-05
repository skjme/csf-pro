package nio.networkinterface;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

public class Test6 {

    public static void main(String[] args) {

        try{

            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaceEnumeration.hasMoreElements()){
                NetworkInterface eachNetworkInterface = networkInterfaceEnumeration.nextElement();

                System.out.println();
                System.out.println(eachNetworkInterface.getName());
                System.out.println(eachNetworkInterface.getDisplayName());
                System.out.println(eachNetworkInterface.isPointToPoint());// 点对点
                System.out.println(eachNetworkInterface.supportsMulticast());// 多播
                System.out.println(eachNetworkInterface.supportsMulticast());// 多播

                List<InterfaceAddress> interfaceAddresses = eachNetworkInterface.getInterfaceAddresses();
                for(int i = 0 ; i < interfaceAddresses.size(); i++){
                    InterfaceAddress eachAddress = interfaceAddresses.get(i);
                    InetAddress inetAddress = eachAddress.getAddress();
                    if(inetAddress != null){
                        System.out.println("eachAddress.getHostAddress()= " + inetAddress.getHostAddress());
                    }
                    inetAddress = eachAddress.getBroadcast();
                    if(inetAddress != null){
                        System.out.println("eachAddress.getBroadcast()= " + inetAddress.getHostAddress());
                    }
                    System.out.println("eachAddress.getNetworkPrefixLength()=" + eachAddress.getNetworkPrefixLength());
                    System.out.println();

                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
