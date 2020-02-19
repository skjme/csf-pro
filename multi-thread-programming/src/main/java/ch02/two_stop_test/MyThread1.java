package ch02.two_stop_test;

public class MyThread1 extends Thread{

    private Service service;

    public MyThread1(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.methodA();
    }
}
