package ch02.string;

public class MyThread2 extends Thread {

    private Service service;

    public MyThread2(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
//        this.service.print("bb");
        this.service.print(new Object());
    }
}
