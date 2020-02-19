package ch02.dead_lock_test;

public class DeadThread implements Runnable {

    private String username;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void setFlag(String username) {
        this.username = username;
    }

    public void run() {
        if (username.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("username=" + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("按lock1->lock2代码顺序执行");
                }
            }
        }

        if (username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username=" + username);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("按lock2->lock1代码顺序执行");
                }
            }
        }
    }
}
