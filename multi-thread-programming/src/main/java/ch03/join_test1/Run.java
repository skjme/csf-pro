package ch03.join_test1;

public class Run {

    public static void main(String[] args) {

        try{
            MyThread myThread = new MyThread();
            myThread.start();

            myThread.join(); // 等待该线程对象销毁 Waits for this thread to die.

            System.out.println("我想等myThread执行完后我再执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
