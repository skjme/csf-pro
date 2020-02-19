package ch02.t9;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyOneList list = new MyOneList();
        MyThread1 t1 = new MyThread1(list);
        t1.setName("a");
        t1.start();

        MyThread2 t2 = new MyThread2(list);
        t2.setName("b");
        t2.start();

        Thread.sleep(6000);

        System.out.println("list=" + list);
        System.out.println("listSize=" + list.getSize());
    }
}
