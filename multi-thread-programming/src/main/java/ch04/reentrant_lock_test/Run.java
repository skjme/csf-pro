package ch04.reentrant_lock_test;

public class Run {
    public static void main(String[] args) {

        // 使用ReentrantLock实现同步
        MyService service = new MyService();
        new MyThread(service).start();
        new MyThread(service).start();
        new MyThread(service).start();
        new MyThread(service).start();
        new MyThread(service).start();
    }
}
