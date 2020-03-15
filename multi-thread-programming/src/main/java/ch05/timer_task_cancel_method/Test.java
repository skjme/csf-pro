package ch05.timer_task_cancel_method;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test {

    public static void main(String[] args) {
        System.out.println("now:" + new Date());
        Calendar calendar = Calendar.getInstance();
        Date runDate1 = calendar.getTime();
        System.out.println("计划时间为：" + runDate1);
        MyTaskA task1 = new MyTaskA();
        MyTaskB task2 = new MyTaskB();
        Timer timer = new Timer();
        timer.schedule(task1, runDate1, 4000);
        timer.schedule(task2, runDate1, 4000);
    }
}
