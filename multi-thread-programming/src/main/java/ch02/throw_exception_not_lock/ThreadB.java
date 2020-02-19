package ch02.throw_exception_not_lock;

public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        this.service.testMethod();
    }
}
