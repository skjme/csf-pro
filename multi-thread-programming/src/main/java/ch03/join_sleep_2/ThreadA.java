package ch03.join_sleep_2;

public class ThreadA extends Thread {

    private ThreadB b;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        try{
            synchronized (b){
                b.start();
                b.join(); // 说明join释放锁了
                for(int i = 0; i < Integer.MAX_VALUE; i++){
                    String newString = new String();
                    Math.random();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
