package enjoy.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "enjoy")
public class LockTest4 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();


        //t2首先获取锁 然后阻塞5s
        new Thread(()->{
            try {
                lock.lock();//获取锁
                    log.debug("获取锁----");
                    TimeUnit.SECONDS.sleep(5);
                    log.debug("t2 5s 之后继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t2").start();

        //主要是为了让t2先拿到锁
        TimeUnit.SECONDS.sleep(1);




        //t1加锁失败因为被t2持有
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                log.debug("t1 获取了锁--执行代码");
            } catch (Exception e) {
                e.printStackTrace();
                log.debug("被打断了没有获取锁");

                return;
            } finally {
                lock.unlock();
            }
        }, "t1");
        t1.start();



        //由于t1 可以被打断 故而1s之后打断t1 不在等待t2释放锁了
        try {
            TimeUnit.SECONDS.sleep(2);
            log.debug("主线程------2s后打断t1");
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
