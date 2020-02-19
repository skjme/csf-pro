package ch02.synchronized_method_lock_object;

public class Run {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        a.start();
        ThreadB b= new ThreadB(object);
        b.setName("B");
        b.start();

    }
}
