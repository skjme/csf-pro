package enjoy.concurrency.lock;


import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "enjoy")
public class LockTest7 {
    static final Object lock = new Object();
    // 表示 t2 是否运行过
    static boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("a");
            }
        }, "t1");


        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.debug("b");
                flag = true;
                lock.notify();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
