package enjoy.concurrency.lock;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.LockSupport;
import java.util.logging.Logger;

@Slf4j(topic = "enjoy")
public class LockTest8 {


    /**
     * t1  --a
     * t2  --b
     * t3----c
     * @param args
     */
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.debug("a");
        }, "t1");
        t1.start();

        new Thread(() -> {
            log.debug("b");
            LockSupport.unpark(t1);
        },"t2").start();
    }
}
