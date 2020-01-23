package nio.buffer;

import java.nio.ByteBuffer;

public class TestBuffer13 {

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        byteBuffer.limit(3);
        byteBuffer.position(2);
        System.out.println("byteBuffer.hasRemaining=" + byteBuffer.hasRemaining()
                + " byteBuffer.remaining=" + byteBuffer.remaining());

        System.out.println(byteBuffer);
        System.out.println();

        byte[] bytes1 = new byte[]{1,2,3,4,5,6,7,8,9};
        ByteBuffer buffer = ByteBuffer.wrap(bytes1);

        int remaining = buffer.remaining();
        System.out.println(buffer.position() + ", " + buffer.limit());

        for (int i = 0; i < remaining; i++){
            System.out.print(buffer.get() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("clear before: " + buffer.position() + ", " + buffer.limit());
        buffer.clear();
        System.out.println("clear after: " + buffer.position() + ", " + buffer.limit());

        while (buffer.hasRemaining()){
            System.out.print(buffer.get() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("clear before: " + buffer.position() + ", " + buffer.limit());
        buffer.clear();
        System.out.println("clear after: " + buffer.position() + ", " + buffer.limit());

        for (; buffer.hasRemaining() == true; ){
            System.out.print(buffer.get() + " ");
        }

    }
}
