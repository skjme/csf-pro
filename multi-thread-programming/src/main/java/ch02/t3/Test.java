package ch02.t3;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadA a = new ThreadA(publicVar);
        a.start();

        Thread.sleep(600);

        publicVar.getValue();
    }
}
