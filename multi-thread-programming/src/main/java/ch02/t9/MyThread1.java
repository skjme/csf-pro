package ch02.t9;

public class MyThread1 extends Thread {

    private MyOneList list;

    public MyThread1(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        MyService service = new MyService();
        service.addServiceMethod(list, "A");
    }
}
