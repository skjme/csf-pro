package ch02.t8;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        // 验证synchronized(this)代码块锁是锁定当前对象

        Task task = new Task();
        new MyThread1(task).start();
        Thread.sleep(500);
        new MyThread2(task).start();


    }
}
