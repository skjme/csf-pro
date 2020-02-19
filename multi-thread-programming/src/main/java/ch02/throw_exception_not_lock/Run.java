package ch02.throw_exception_not_lock;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        Service s = new Service();
        ThreadA a = new ThreadA(s);
        a.setName("a");
        a.start();

        Thread.sleep(500);

        ThreadA b = new ThreadA(s);
        b.setName("b");
        b.start();

    }
}
