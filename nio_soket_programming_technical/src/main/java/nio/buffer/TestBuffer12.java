package nio.buffer;

import java.nio.ByteBuffer;

public class TestBuffer12 {

    public static void main(String[] args) {

//        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);

        byteBuffer.put((byte)1);
        byteBuffer.put((byte)2);

        // 判断是否有底层实现的数组
        //  (hb != null) && !isReadOnly;
        //  hb 是否有值来判断是否有底层数组来支持
        // 直接缓冲区返回为false，说明直接将数据存入了内存中，hb为null
        System.out.println(byteBuffer.hasArray());
    }
}
