package javase.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ConvertTest {

    public static void main(String[] args) {

//         旧API转新API

        // Date -> Instant
        Instant ins1 = new Date().toInstant();
        System.out.println(ins1);

        // Calendar -> Instant -> ZonedDateTime
        Instant ins2 = Calendar.getInstance().toInstant();
        Calendar calendar = Calendar.getInstance();
        ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());
        System.out.println(zdt);


//        新API转旧API

        // ZonedDateTime -> long
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        long ts = zonedDateTime.toEpochSecond() * 1000;
        System.out.println(ts);

        // long -> Date
        Date date = new Date(ts);
        System.out.println(date);

        // long -> Calender
        Calendar c = Calendar.getInstance();
        c.clear();
        c.setTimeZone(TimeZone.getTimeZone(zonedDateTime.getZone().getId()));
        c.setTimeInMillis(zonedDateTime.toEpochSecond() * 10000);
        System.out.println(c);




    }
}
