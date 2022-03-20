package cn.shukejian.jvm.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chaseshu
 * @date 2022/3/16 15:12
 * @apiNote
 */
public class TestFairSync {
    
    public static void main(String[] args) {
        // ReentrantLock lock = new ReentrantLock(false);
        ReentrantLock lock = new ReentrantLock(true);
        
        lock.lock();
    }
}
