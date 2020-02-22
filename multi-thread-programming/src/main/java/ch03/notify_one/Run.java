package ch03.notify_one;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread1(lock).start();
        new Thread1(lock).start();
        new Thread1(lock).start();
        Thread.sleep(1000);
        new NotifyThread(lock).start();

    }
}
