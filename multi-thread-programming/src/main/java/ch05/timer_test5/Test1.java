package ch05.timer_test5;

import ch04.read_write_lock_begin1.ThreadA;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test1 {

    static class MyTask extends TimerTask{
        public void run(){
            try{
                System.out.println("begin time" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("  end time" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(myTask, runDate, 3000);
    }
}
