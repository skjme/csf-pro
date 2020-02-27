package javase.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 获取时间戳
 */
public class InstantTest {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond());// 秒
        System.out.println(now.toEpochMilli());// 毫秒

        // 以指定时间戳创建Instant:
        Instant ins = Instant.ofEpochSecond(1568568760);
        ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
        System.out.println(zdt);
    }
}
