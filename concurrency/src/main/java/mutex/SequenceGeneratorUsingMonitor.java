package mutex;

import com.google.common.util.concurrent.Monitor;

/**
 * 4.Using Guava's Monitor Class 实现互斥锁 implement mutex
 */
public class SequenceGeneratorUsingMonitor extends SequenceGenerator {
    
    private Monitor mutex = new Monitor();

    @Override
    public int getNextSequence() {
        mutex.enter();
        try {
            return super.getNextSequence();
        } finally {
            mutex.leave();
        }
    }

}