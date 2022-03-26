package enjoy.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "enjoy")
public class LockTest1 {
    static volatile int count = 100;
    static final Object lock = new Object();


    public static void main(String[] args) {
        //t1线程对count一直做减法 直到减为0才结束
        new Thread(() -> {
            while (count > 0) {
                try {
                    TimeUnit.NANOSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                log.debug("count: {}", count);
            }
        }, "t1").start();


        //t2线程对count一直做加法 直到加为20才结束
        new Thread(() -> {
            while (count < 200) {
                try {
                    TimeUnit.NANOSECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                log.debug("count: {}", count);
            }
        }, "t2").start();
    }
}
