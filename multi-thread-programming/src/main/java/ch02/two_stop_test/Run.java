package ch02.two_stop_test;

public class Run {

    public static void main(String[] args) {
        Service s= new Service();
        new MyThread1(s).start();
        new MyThread2(s).start();
    }
}
