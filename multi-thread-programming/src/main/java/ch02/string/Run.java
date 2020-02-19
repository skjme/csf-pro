package ch02.string;

public class Run {

    public static void main(String[] args) {
        Service s = new Service();
        MyThread1 t1 = new MyThread1(s);
        t1.setName("A");
        t1.start();

//        MyThread2 t2 = new MyThread2(s);
//        t2.setName("B");
//        t2.start();

        MyThread1 t2 = new MyThread1(s);
        t2.setName("B");
        t2.start();
    }
}
