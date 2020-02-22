package ch03.notify_hold_lock;

public class Run {

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread1(lock).start();
        new NotifyThread(lock).start();
    }
}
