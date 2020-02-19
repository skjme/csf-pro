package ch02.synchronized_method_lock_object;

public class ThreadA extends Thread {
    private MyObject object;

    public ThreadA(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
