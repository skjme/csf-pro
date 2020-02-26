package ch04.lock_method_test1;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition newCondition = lock.newCondition();

    public void waitMethod(){
        try {
            lock.lock();
            newCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void notifyMethod(){
        try{
            lock.lock();
            System.out.println("有 " + lock.getWaitQueueLength(newCondition) + " 线程正在等待newCondition");
            newCondition.signal();

        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {


        final Test3 service = new Test3();
        Runnable runnable = new Runnable() {
            public void run() {
                service.waitMethod();
            }
        };

        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(runnable);
        }
        for(int i = 0; i < threads.length; i++){
            threads[i].start();
        }

        Thread.sleep(2000);
        service.notifyMethod();
    }
}
