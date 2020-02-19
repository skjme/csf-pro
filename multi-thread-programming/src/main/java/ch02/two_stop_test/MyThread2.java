package ch02.two_stop_test;

public class MyThread2 extends Thread{

    private Service service;

    public MyThread2(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.methodB();
    }
}
