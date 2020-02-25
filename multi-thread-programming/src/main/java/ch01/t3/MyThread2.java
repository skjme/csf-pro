package ch01.t3;

public class MyThread2 extends Thread{

    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由"+ currentThread().getName() +" 计算 count=" + count);

    }

    public static void main(String[] args) {

        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread2, "A");
        Thread t2 = new Thread(myThread2, "B");
        Thread t3 = new Thread(myThread2, "C");
        Thread t4 = new Thread(myThread2, "D");
        Thread t5 = new Thread(myThread2, "E");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
