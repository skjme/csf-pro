package ch03.join_sleep_1;

public class ThreadC extends Thread {

    private ThreadB b;

    public ThreadC(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        b.bService();
    }
}
