package nio.buffer.bytebuffer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class Test2 {

    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.out.println("A");
        ByteBuffer buffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE);
        System.out.println("B");
        byte[] byteArray = new byte[] {1};
        System.out.println(Integer.MAX_VALUE);
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            buffer.put(byteArray);
        }
        System.out.println("put end!");

        // 由JVM进行自动化
        // 此程序多次运行后，一直在耗费内存
        // 进程结束后，也不会马上回收内存
        // 而是会在某个时机出发GC垃圾回收器进行内存的回收


    }
}
