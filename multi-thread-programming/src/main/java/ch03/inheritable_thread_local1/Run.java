package ch03.inheritable_thread_local1;

public class Run extends  Thread {
    public static void main(String[] args) {

        try{
            for(int i = 0; i < 10; i++){
                System.out.println("在线程Main中的取值=" + Tools.t1.get());
                Thread.sleep(100);
            }

            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
