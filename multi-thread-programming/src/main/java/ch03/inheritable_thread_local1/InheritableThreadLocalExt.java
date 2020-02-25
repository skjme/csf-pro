package ch03.inheritable_thread_local1;

import java.util.Date;

public class InheritableThreadLocalExt extends InheritableThreadLocal {

    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + " 我在子线程加的~！";
    }
}
