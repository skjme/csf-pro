package ch04.fair_nofair_test;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock;

    public Service(boolean isfair){
        lock = new ReentrantLock(isfair);
    }

    public void serviceMethod(){
        try{
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " 获得锁定");
        }finally {
            lock.unlock();
        }
    }
}
