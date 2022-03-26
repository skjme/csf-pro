package enjoy.concurrency.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author chaseshu
 * @date 2022/3/20 16:51
 * @apiNote
 */
public class MyLock implements Lock {
    
    MySync sync = new MySync();
    
    @Override
    public void lock() {
        sync.tryAcquire(1);
    }
    
    @Override
    public void lockInterruptibly() throws InterruptedException {
    
    }
    
    @Override
    public boolean tryLock() {
        return false;
    }
    
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
    
    @Override
    public void unlock() {
    
    }
    
    @Override
    public Condition newCondition() {
        return null;
    }
}
