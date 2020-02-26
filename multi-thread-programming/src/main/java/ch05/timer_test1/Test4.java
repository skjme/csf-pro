package ch05.timer_test1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test4 {

    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date runDate = calendar.getTime();

        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();

        Timer timer = new Timer();
        timer.schedule(task1, runDate);
        timer.schedule(task2, runDate, 4000);
    }
}
