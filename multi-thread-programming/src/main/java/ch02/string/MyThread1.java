package ch02.string;

public class MyThread1 extends Thread {

    private Service service;

    public MyThread1(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
//        this.service.print("aa");
        this.service.print(new Object());
    }
}
