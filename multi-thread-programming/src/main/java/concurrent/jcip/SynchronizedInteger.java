package concurrent.jcip;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SynchronizedInteger {

    @GuardedBy("this")
    private int value;

    synchronized
    public int getValue() {
        return value;
    }

    synchronized
    public void setValue(int value) {
        this.value = value;
    }
}
