package nio.networkinterface;

import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 获取硬件地址 即获取网卡的硬件地址（物理地址 ）、MAC（Media Access Control）地址、
 * 网卡设备的唯一ID， 采用16进制、一共48位
 */
public class Test4HardwardAddress {
    public static void main(String[] args) {
        try {

//            获取网络设备名称=en0
//            获取网络设备显示名称=en0
//            获取网卡的物理地址=
//            -12 92 -119 -64 -111 -19 (十进制)
//            **10进制负数转16进制：256-12=244=>f4 在线转换：https://tool.lu/hexconvert/
//            ether f4:5c:89:c0:91:ed (十六进制)

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("获取网络设备名称=" + networkInterface.getName());
                System.out.println("获取网络设备显示名称=" + networkInterface.getDisplayName());
                System.out.println("获取网卡的物理地址=" );
                byte[] byteArray = networkInterface.getHardwareAddress();
                if(byteArray != null && byteArray.length != 0){
                    for (int i = 0; i < byteArray.length; i++){
                        System.out.print(byteArray[i] + " ");
                    }
                    System.out.println();
                    for (int i = 0; i < byteArray.length; i++){
//                        System.out.print(Integer.toHexString(byteArray[i]) + " ");
                        int num = (int) byteArray[i];
                        if(num < 0){
                            num = 256 - Math.abs(num);
                        }
                        System.out.print(Integer.toHexString(num)+ " ");
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
