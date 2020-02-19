package ch02.t5;

public class Run {

    public static void main(String[] args) {
        Task task = new Task();
        MyThread1 t1 = new MyThread1(task);
        t1.start();
        MyThread2 t2 = new MyThread2(task);
        t2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime1;
        if(CommonUtils.beginTime2 < CommonUtils.beginTime1){
            beginTime = CommonUtils.beginTime2;
        }
        long endTime = CommonUtils.endTime1;
        if(CommonUtils.endTime2 > CommonUtils.endTime1){
            endTime = CommonUtils.endTime2;
        }
        System.out.println("take time = " + (endTime - beginTime));
    }
}
