package mutex;

import java.util.concurrent.Semaphore;

/**
 * 3.Using Semaphore Class 实现互斥锁 implement mutex
 */
public class SequenceGeneratorUsingSemaphore extends SequenceGenerator {
    
    private Semaphore mutex = new Semaphore(1);

    @Override
    public int getNextSequence() {
        try {
            mutex.acquire();
            return super.getNextSequence();
        } catch (InterruptedException e) {
            // exception handling code
            throw new RuntimeException("Exception in critical section.", e);
        } finally {
            mutex.release();
        }
    }
}