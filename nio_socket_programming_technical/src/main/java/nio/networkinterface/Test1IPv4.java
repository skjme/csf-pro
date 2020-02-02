package nio.networkinterface;

import java.math.BigDecimal;

public class Test1IPv4 {

    public static void main(String[] args) {

        // IPv4 32位二进制， 分4组，每组8位
        // IPv4地址总数：
        double getValue = Math.pow(2, 32);
        BigDecimal bigDecimal = new BigDecimal("" + getValue);
        System.out.println(bigDecimal.toString());

    }
}
