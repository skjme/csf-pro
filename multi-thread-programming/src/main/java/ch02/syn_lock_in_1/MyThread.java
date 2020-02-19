package ch02.syn_lock_in_1;

public class MyThread  extends  Thread{

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.service1();
    }


}
