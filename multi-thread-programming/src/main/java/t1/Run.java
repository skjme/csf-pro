package t1;

public class Run {

    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println("运行结束！");

//        try{
//            for(int i = 0; i < 10; i++){
//                int time = (int)(Math.random() * 1000);
//                Thread.sleep(time);
//                System.out.println("run=" + Thread.currentThread().getName());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
