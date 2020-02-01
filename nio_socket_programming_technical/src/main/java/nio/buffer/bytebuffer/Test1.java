package nio.buffer.bytebuffer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.nio.ByteBuffer;

public class Test1 {

    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(100);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(200);

        System.out.println("byteBuffer1 position="+ byteBuffer1.position() + " limit=" + byteBuffer1.limit());
        System.out.println("byteBuffer2 position="+ byteBuffer2.position() + " limit=" + byteBuffer2.limit());


        System.out.println("byteBuffer1=" + byteBuffer1 + " isDirect=" + byteBuffer1.isDirect());
        System.out.println("byteBuffer2=" + byteBuffer2 + " isDirect=" + byteBuffer2.isDirect());


        System.out.println("A");
        ByteBuffer buffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE);
        System.out.println("B");
        byte[] byteArray = new byte[] {1};
        System.out.println(Integer.MAX_VALUE);
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            buffer.put(byteArray);
        }
        System.out.println("put end!");
        Thread.sleep(1000);

        Method cleanerMethod = buffer.getClass().getMethod("cleaner");
        cleanerMethod.setAccessible(true);
        Object returnValue = cleanerMethod.invoke(buffer);
        Method cleanMethod = returnValue.getClass().getMethod("clean");
        cleanMethod.setAccessible(true);
        cleanMethod.invoke(returnValue);

        // 此程序运行的效果就是1秒钟之后立即回收内存
        // 也就是回收"直接缓冲区"所占用的内存


    }
}
