package ch05.timer_test1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test3 {

    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) -10);
        Date runDate = calendar.getTime();
        System.out.println("计划时间为：" + runDate);

        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, runDate);
    }
}
