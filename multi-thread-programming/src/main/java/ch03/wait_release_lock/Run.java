package ch03.wait_release_lock;

public class Run {

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread1(lock).start();
        new Thread2(lock).start();
    }
}
