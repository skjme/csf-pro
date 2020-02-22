package ch03.test2;

public class MyThread2 extends Thread {

    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
            synchronized (lock){
                System.out.println("begin notify time = " + System.currentTimeMillis());
                lock.notify();
                System.out.println("begin notify time = " + System.currentTimeMillis());
            }
    }
}
