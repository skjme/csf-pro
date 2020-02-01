package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;

public class Test4 {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes, 2, 4);

        System.out.println("byteBuffer1 capacity=" + byteBuffer.capacity()
        +" limit=" + byteBuffer.limit() + " position=" +byteBuffer.position());

        System.out.println();

        System.out.println("byteBuffer2 capacity=" + byteBuffer2.capacity()
                +" limit=" + byteBuffer2.limit() + " position=" +byteBuffer2.position());

        System.out.println();
        byteBuffer.put((byte) 123);
        byteBuffer.get();
        System.out.println("byteBuffer1 capacity=" + byteBuffer.capacity()
                +" limit=" + byteBuffer.limit() + " position=" +byteBuffer.position());

        System.out.println();
        ByteBuffer bb = ByteBuffer.allocate(10);
        bb.put(bytes);
        System.out.println("bb capacity=" + bb.capacity()
                +" limit=" + bb.limit() + " position=" +bb.position());
        bb.position(2);
        System.out.println("bb capacity=" + bb.capacity()
                +" limit=" + bb.limit() + " position=" +bb.position());
        byte[] bytes2 = new byte[]{ 55, 66, 77, 88};
        bb.put(bytes2, 1, 3);
        System.out.println("bb capacity=" + bb.capacity()
                +" limit=" + bb.limit() + " position=" +bb.position());
        bb.position(0);
        System.out.println(bb.toString());
        byte[] array = bb.array();
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();

        bb.position(1);

        // 导出数据
        byte[] byteArrayOut = new byte[bb.capacity()];
        bb.get(byteArrayOut, 3, 4);
        for(int i = 0; i < byteArrayOut.length; i++){
            System.out.print(byteArrayOut[i] + " ");
        }

        System.out.println();
        ByteBuffer bb2 = ByteBuffer.allocate(10);
       // bb2.put(bytes, 0, bb2.capacity()); // throw IndexOutOfBoundsException

        bb2.position(9);
        bb2.put(bytes, 0, 4); // throw BufferOverflowException


    }
}
