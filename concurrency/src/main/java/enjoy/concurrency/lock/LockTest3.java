package enjoy.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "enjoy")
public class LockTest3 {

    //首先定义一把锁
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock1();
    }


    public static void lock1() {
        lock.lock();
        try {
            log.debug("执行lock1");
            //重入
            lock2();
        } finally {
            lock.unlock();
        }
    }



    public static void lock2() {
        lock.lock();
        try {
            log.debug("执行lock2");
        } finally {
            lock.unlock();
        }
    }

}
