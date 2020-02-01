package nio.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class TestBuffer16 {

    public static void main(String[] args) {

        ByteBuffer buffer1 = ByteBuffer.wrap(new byte[]{ 'a', 'b', 'c'});
        ByteBuffer buffer2 = ByteBuffer.wrap(new byte[]{ 'x', 'y', 'z'});
        ByteBuffer buffer3 = ByteBuffer.wrap(new byte[]{ '1', '2', '3'});

        List<ByteBuffer> list = new ArrayList<>();
        list.add(buffer1);
        list.add(buffer2);
        list.add(buffer3);

        ByteBuffer[] byteBufferArray = new ByteBuffer[list.size()];
        list.toArray(byteBufferArray);

        System.out.println(list.size());
        System.out.println(byteBufferArray.length);

        for (int i = 0; i < byteBufferArray.length; i++){
            ByteBuffer eachByteBuffer = byteBufferArray[i];
            while (eachByteBuffer.hasRemaining()){
                System.out.print((char) eachByteBuffer.get() + " ");
            }
            System.out.println();
        }
    }
}
