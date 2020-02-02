package nio.networkinterface;

import java.math.BigDecimal;

public class Test1IPv6 {

    public static void main(String[] args) {

        // IPv6 128位二进制， 分8组，每组16位
        // IPv6地址总数：
        double getValue = Math.pow(2, 128);
        BigDecimal bigDecimal = new BigDecimal("" + getValue);
        System.out.println(bigDecimal.toString());

    }
}
