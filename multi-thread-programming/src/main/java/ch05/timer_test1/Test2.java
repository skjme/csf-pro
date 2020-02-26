package ch05.timer_test1;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test2 {

    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date runDate = calendar.getTime();

        MyTask task = new MyTask();
        Timer timer = new Timer(true); // 设置为守护线程
        timer.schedule(task, runDate);
    }
}
