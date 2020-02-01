package nio.buffer;

import java.nio.ByteBuffer;

public class TestBuffer14Rewind {

    public static void main(String[] args) {

        byte[] byteArray = new byte[]{1,2,3,4,5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);

        System.out.println("capacity=" + byteBuffer.capacity() + " limit=" + byteBuffer.limit()
        + " position=" + byteBuffer.position());

        byteBuffer.position(1);
        byteBuffer.limit(3);
        byteBuffer.mark();

        System.out.println("capacity=" + byteBuffer.capacity() + " limit=" + byteBuffer.limit()
                + " position=" + byteBuffer.position());

        byteBuffer.rewind();

        System.out.println("capacity=" + byteBuffer.capacity() + " limit=" + byteBuffer.limit()
                + " position=" + byteBuffer.position());

        byteBuffer.reset();// 此时mark=-1失效，抛异常

    }
}
