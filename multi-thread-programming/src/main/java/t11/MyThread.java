package t11;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("已经是停止状态了！我要退出来！");
                    //break;
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("我在for下面");
        }catch (InterruptedException e){
            System.out.println("进入MyThread.java类方法中的catch了！");
            e.printStackTrace();
        }
    }
}
