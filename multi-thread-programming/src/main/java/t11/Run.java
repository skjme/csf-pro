package t11;

public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
//            Thread.currentThread().interrupt();
            System.out.println("是否停止1？ = " + thread.isInterrupted());
            System.out.println("是否停止1？ = " + thread.isInterrupted());
        }catch (Exception e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
