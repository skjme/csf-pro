package ch01.t15;

public class MyThread extends Thread {

    @Override
    public void run() {

        try{
            for(int i = 0; i < 10000; i++){
                System.out.println("i=" + (i+1));
            }
            System.out.println("run begin");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，再遇到sleep 了，进入catch");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(20);
//        t.interrupt();
        t.stop();
        System.out.println("end!");
    }
}
