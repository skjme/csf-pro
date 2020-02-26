package ch04.read_write_lock_begin2;

public class Run {

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA t1 = new ThreadA(service);
        t1.setName("A");
        ThreadA t2 = new ThreadA(service);
        t2.setName("B");

        t1.start();
        t2.start();
    }
}
