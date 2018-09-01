package com.example.demo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class TicketTest {

    private int count = 100;//100张票

    private Lock lock = new ReentrantLock();

    @Test
    public void ticketTest() throws InterruptedException {

        TicketRunnable tr = new TicketRunnable();

        //四个线程对应四个窗口
        Thread t1 = new Thread(tr, "窗口1");
        Thread t2 = new Thread(tr, "窗口2");
        Thread t3 = new Thread(tr, "窗口3");
        Thread t4 = new Thread(tr, "窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // 主线程等待子线程执行完毕
        Thread.currentThread().join();
    }

    class TicketRunnable implements Runnable{

        @Override
        public void run() {

            while(count > 0){
                if(count >0){

                    //加锁
                    lock.lock();
                    try{
                        //业务代码开始
                        System.out.println(Thread.currentThread().getName()+"售出第"+ (count--) +"张票");
                        //业务代码结束
                    }catch(Exception ex){

                    }finally{//解锁
                        lock.unlock();
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}