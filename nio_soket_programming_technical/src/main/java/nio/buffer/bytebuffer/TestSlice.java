package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;

public class TestSlice {

    public static void main(String[] args) {

        byte[] byteArrayIn1 = {1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer buffer = ByteBuffer.wrap(byteArrayIn1);
        buffer.position(5);
        ByteBuffer buffer2 = buffer.slice();
        System.out.println(buffer);
        System.out.println(buffer2);

        //buffer2.put(0, (byte) 111);
        buffer.put(5, (byte) 111);

        byte[] byteArray1 = buffer.array();
        byte[] byteArray2 = buffer2.array();

        for(int i = 0; i < byteArray1.length; i++){
            System.out.print(byteArray1[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < byteArray2.length; i++){
            System.out.print(byteArray2[i] + " ");
        }
        System.out.println();

        buffer.position(5);
        ByteBuffer bb3 = buffer.slice();
        System.out.println(bb3.arrayOffset());


    }
}
