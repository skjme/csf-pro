package nio.buffer;

import java.nio.ByteBuffer;

public class TestBuffer15Offset {

    public static void main(String[] args) {

        byte[] bytes = new byte[]{1, 2, 3};

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        System.out.println(byteBuffer.arrayOffset());
    }
}
