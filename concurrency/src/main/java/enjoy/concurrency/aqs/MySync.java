package enjoy.concurrency.aqs;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * 同步器 工具
 * @author chaseshu
 * @date 2022/3/20 16:42
 * @apiNote
 */
public class MySync extends AbstractQueuedLongSynchronizer {
    
    @Override
    protected boolean tryAcquire(long arg) {
        if(getState() == 0){
            boolean b = compareAndSetState(0, 1);
            if(b){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected boolean tryRelease(long arg) {
        return super.tryRelease(arg);
    }
    
    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
