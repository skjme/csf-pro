package ch03.two_thread_trans_data;

public class Run  {

    public static void main(String[] args) {

        try{
            Object lock = new Object();

            ThreadB b = new ThreadB(lock);
            b.setName("B");
            b.start();

            Thread.sleep(1000);

            ThreadA a = new ThreadA(lock);
            a.setName("A");
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
