package enjoy.concurrency.lock;

import jdk.nashorn.internal.ir.Block;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "enjoy")
public class LockTest {

    //定义两把锁
    static Object x = new Object();
    static Object y = new Object();

    public static void main(String[] args) {
        //线程1启动
        new Thread(()->{
            //获取x的锁
            synchronized (x){
                log.debug("locked x");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (y){//mutext ----
                    log.debug("locked x");
                    log.debug("t1---------");
                }
            }

        },"t1").start();



        new Thread(()->{
            synchronized (y){
                log.debug("locked y");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (x){
                    log.debug("locked x");
                    log.debug("t2---------");
                }
            }

        },"t2").start();




//        Thread t= null;
//        //等待t执行完
//        t.join();
    }


}
