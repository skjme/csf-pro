package ch03.wait_has_param_method;


import ch03.wait_release_lock.Thread1;

public class MyRunnable {

    static private Object lock = new Object();
    static private Runnable runnable = new Runnable() {
        public void run() {
            try{
                synchronized (lock){
                    System.out.println("wait begin time=" + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end time=" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    static private Runnable runnable2 = new Runnable() {
        public void run() {
            synchronized (lock){
                System.out.println("notify begin time=" + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end time=" + System.currentTimeMillis());
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(runnable).start();


//        Thread.sleep(3000);
//        new Thread(runnable2).start();
    }

}
