package ch04.condition_test_more_method;

public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadAA aa = new ThreadAA(service);
        aa.setName("AA");
        aa.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        ThreadBB bb = new ThreadBB(service);
        bb.setName("BB");
        bb.start();

    }
}
