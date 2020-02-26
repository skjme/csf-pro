package ch04.lock_method_test1;


import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    private ReentrantLock lock = new ReentrantLock();

    public void method1(){
        try{
            lock.lock();
            System.out.println("getHoldCount()=" + lock.getHoldCount());

            method2();
        }finally {
            lock.unlock();
        }
    }

    public void method2() {
        try{
            lock.lock();
            System.out.println("getHoldCount()=" + lock.getHoldCount());
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Test1().method1();
    }
}
