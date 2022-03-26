package enjoy.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "enjoy")
public class LockTest6 {


    static final ReentrantLock lock = new ReentrantLock();
    static boolean isPrettyGril = false; // 女人
    static boolean isMoney = false;//工资

    //没有女人的 waitSet
    static Condition waitpg = lock.newCondition();
    // 没有钱的waitSet
    static Condition waitm = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                lock.lock();
                log.debug("有没有女人[{}]", isPrettyGril);
                while (!isPrettyGril) {
                    log.debug("没有女人！等女人");
                    try {
                        waitpg.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("男女搭配干活不累；啪啪啪写完了代码");
            }finally {
                lock.unlock();
            }
        }, "jack").start();



        new Thread(() -> {
            try {
                lock.lock();
                log.debug("有没有工资[{}]", isMoney);
                while (!isMoney) {
                    log.debug("没有工资！等发工资");
                    try {
                        waitm.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("-----卧槽好多钱；啪啪啪写完了代码");

            }finally {
                lock.unlock();
            }
        }, "rose").start();



        Thread.sleep(1000);
        new Thread(() -> {
            try {
                lock.lock();
                isMoney = true;
                log.debug("钱来哦了");

                isPrettyGril=true;
                log.debug("桥老师");
                //waitpg.signal();
                waitm.signalAll();

            }finally {
                lock.unlock();
            }
        }, "boss").start();
    }

}