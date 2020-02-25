package ch01.suspend_resume_test;


public class Run {

    public static void main(String[] args) {

        // 暂停线程


        try{
            MyThread t =new MyThread();
            t.start();
            Thread.sleep(5000);

            t.suspend();
            System.out.println("A " + System.currentTimeMillis() +" i=" + t.getI());
            Thread.sleep(5000);
            System.out.println("A " + System.currentTimeMillis() +" i=" + t.getI());

            t.resume();
            Thread.sleep(5000);

            t.suspend();
            System.out.println("B " + System.currentTimeMillis() +" i=" + t.getI());
            Thread.sleep(5000);
            System.out.println("B " + System.currentTimeMillis() +" i=" + t.getI());

            t.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
