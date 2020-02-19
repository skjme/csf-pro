package ch02.syn_lock_in_2;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        Sub s = new Sub();
        s.operateISubMethod();
    }
}
