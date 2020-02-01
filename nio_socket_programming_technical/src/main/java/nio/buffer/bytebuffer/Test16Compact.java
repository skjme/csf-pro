package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;

/**
 * 压缩缓冲区
 */
public class Test16Compact {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{1,2,3,4, 5, 6});
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer);

        byteBuffer.compact();
        System.out.println(byteBuffer);
        byte[] array = byteBuffer.array();
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }


        System.out.println();
        System.out.println();
        byteBuffer.position(2);
        ByteBuffer byteBuffer2 = byteBuffer.slice();
        ByteBuffer byteBuffer3 = byteBuffer.duplicate();
        ByteBuffer byteBuffer4 = byteBuffer;

        System.out.println(byteBuffer);
        System.out.println(byteBuffer2);
        System.out.println(byteBuffer3);
        System.out.println(byteBuffer4);
    }
}
