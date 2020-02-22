package ch03.two_thread_trans_data;

public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        try{

//            while(true){
//                    if(MyList.size() == 5){
//                        System.out.println(Thread.currentThread().getName() +
//                                "==5了，线程b要退出了！");
//                        throw new InterruptedException();
//                    }else{
//                        System.out.println(Thread.currentThread().getName() + " size=" + MyList.size());
//                    }
//                }

            synchronized (lock){
                if (MyList.size() != 5){
                    System.out.println("wait begin " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end " + System.currentTimeMillis());
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
