package enjoy.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "enjoy")
public class LockTest5 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();



        Thread t1 = new Thread(() -> {
            log.debug("t1启动---------");

                if (!lock.tryLock()) {//进入if标识拿不到锁
                    log.debug("拿不到鎖，返回");
                    return;
                }

            try {
                log.debug("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");



        //主线程先获取锁
        lock.lock();
        log.debug("主綫程获得了锁");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } finally {
            lock.unlock();
        }

    }
}