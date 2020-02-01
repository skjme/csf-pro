package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;

public class Test15ReadOnly {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{1,2,3,4, 5});
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        System.out.println(byteBuffer.isReadOnly());
        System.out.println(readOnlyBuffer.isReadOnly());

        readOnlyBuffer.rewind();
        readOnlyBuffer.put((byte)123);
    }
}
