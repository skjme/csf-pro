package currentThread;

public class MyThread extends Thread {

    public MyThread() {
        System.out.println("构造方法的打印：" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
    }

    @Override
    public void run() {

        System.out.println("run方法的打印：" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();

        t.start(); // output
//        构造方法的打印：main
//        run方法的打印：Thread-0

//        t.run();
//        构造方法的打印：main
//        run方法的打印：main

    }
}
