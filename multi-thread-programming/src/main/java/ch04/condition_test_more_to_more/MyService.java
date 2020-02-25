package ch04.condition_test_more_to_more;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set(){
        try{
            lock.lock();
            while (hasValue == true){
                System.out.println("有可能❤️❤️连续");
                condition.await();
            }

            System.out.println("打印❤️");
            hasValue = true;
//            condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void get(){
        try{
            lock.lock();
            while(hasValue == false){
                System.out.println("有可能💛💛连续");
                condition.await();
            }
            System.out.println("打印💛");
            hasValue = false;
//            condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
