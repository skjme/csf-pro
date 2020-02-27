package javase.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 带有时区的日期和时间ZonedDateTime
 * 区别LocalDateTime
 */
public class ZonedDateTimeTest {

    public static void main(String[] args) {

        ZonedDateTime zBJ = ZonedDateTime.now();// 默认时区
        ZonedDateTime zoneNY = ZonedDateTime.now(ZoneId.of("America/New_York")); // 指定时区获取当前时间
        System.out.println(zBJ);
        System.out.println(zoneNY);

        // LocalDateTime转换成ZonedDateTime 需附加一个ZoneId,
        LocalDateTime ldt = LocalDateTime.of(2020, 2, 27, 16, 4, 59);
        ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println(ldt);
        System.out.println(zbj);
        System.out.println(zny);

        // 两个时区转换
        ZonedDateTime beijing = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime newyork = beijing.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(beijing);
        System.out.println(newyork);

    }
}
