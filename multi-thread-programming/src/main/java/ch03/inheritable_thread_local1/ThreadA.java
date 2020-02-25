package ch03.inheritable_thread_local1;

public class ThreadA extends  Thread {
    @Override
    public void run() {
        try{
            for(int i = 0; i < 10; i++){
                System.out.println("在线程A中的取值=" + Tools.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
