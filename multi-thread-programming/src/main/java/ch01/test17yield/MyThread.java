package ch01.test17yield;

public class MyThread extends Thread {

    @Override
    public void run() {
        int priority = Thread.currentThread().getPriority();
        System.out.println("priority=" + priority);
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 5000000; i++){
//            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时" + (endTime - beginTime)+ "毫秒");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
