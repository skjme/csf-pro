package ch01.daemonThread;

public class MyThread extends Thread{

    private int i = 0;

    @Override
    public void run() {

        try{
            while(true){
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try{
            MyThread t = new MyThread();
//            t.setDaemon(false);
            t.setDaemon(true);
            t.start();
            Thread.sleep(5000);
            System.out.println("end!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
