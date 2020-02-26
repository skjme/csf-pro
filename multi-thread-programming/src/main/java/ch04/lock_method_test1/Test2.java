package ch04.lock_method_test1;


import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    private ReentrantLock lock = new ReentrantLock();

    public void method1(){
        try{
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " 进入方法了");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {


        final Test2 service = new Test2();
        Runnable runnable = new Runnable() {
            public void run() {
                service.method1();
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

        System.out.println(" 有线程数：" + service.lock.getQueueLength() +" 在等待获取锁！");
    }
}
