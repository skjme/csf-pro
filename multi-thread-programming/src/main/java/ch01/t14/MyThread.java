package ch01.t14;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run Begin");
            Thread.sleep(20000);
            System.out.println("run End");
        }catch (InterruptedException e){
            System.out.println("在沉睡中被停止，进入catch了！" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
