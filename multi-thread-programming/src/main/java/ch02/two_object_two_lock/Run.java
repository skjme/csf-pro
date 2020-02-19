package ch02.two_object_two_lock;


public class Run {
    public static void main(String[] args) {

        // 多个对象 多把锁
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(numRef1);
        a.start();
        ThreadB b = new ThreadB(numRef2);
        b.start();
    }
}
