package ch02.t2;



public class Run {
    public static void main(String[] args) {

        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(numRef);
        a.start();
        ThreadB b = new ThreadB(numRef);
        b.start();
    }
}
