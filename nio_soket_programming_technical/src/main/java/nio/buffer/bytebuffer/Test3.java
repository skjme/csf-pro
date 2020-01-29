package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;

/**
 * 比较 直接缓冲区和非直接缓冲区的创建性能
 */
public class Test3 {

    public static void createDirect(){
        long beginTime = System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1900000000);
        for (int i = 0; i < 1900000000; i++){
            byteBuffer.put((byte) 123);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("创建直接缓冲区花费时间：" + (endTime - beginTime));

    }
    public static void createNotDirect(){
        long beginTime = System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1900000000);
        for (int i = 0; i < 1900000000; i++){
            byteBuffer.put((byte) 123);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("创建非直接缓冲区花费时间：" + (endTime - beginTime));

    }

    public static void main(String[] args) {
        createNotDirect();
        createDirect();

    }
}
