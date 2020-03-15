package ch05.timer_test5;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test2 {

    static class MyTask extends TimerTask {
        public void run(){
                System.out.println("begin time" + new Date());
                System.out.println("  end time" + new Date());

        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        System.out.println("现在执行时间：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 20);
        Date runDate = calendar.getTime();
        System.out.println("计划执行时间：" + runDate);

//        new Timer().schedule(task, runDate, 2000); // 任务不追赶

        new Timer().scheduleAtFixedRate(task, runDate, 2000); // 补充性执行
    }
}
