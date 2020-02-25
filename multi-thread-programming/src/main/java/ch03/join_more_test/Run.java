package ch03.join_more_test;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);

        a.start();
        b.start();
        b.join(2000);

        System.out.println(" main end " + System.currentTimeMillis());
    }
}
