package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;


public class Test13 {

    /**
     * ByteBuffer是按字节单位进行存储，而IntBuffer 是按数据类型为单位来进行存储的
     */
    public static void test1(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("A1=" + byteBuffer.position());
        byteBuffer.putInt(123);
        System.out.println("A2=" + byteBuffer.position());
        byteBuffer.putInt(456);
        System.out.println("A3=" + byteBuffer.position());

        System.out.println();

        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("B1=" + intBuffer.position());
        intBuffer.put(456);
        System.out.println("B2=" + intBuffer.position());
        intBuffer.put(789);
        System.out.println("B3=" + intBuffer.position());

    }

    public static void main(String[] args) {
        test1();


        System.out.println();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(32);
        byteBuffer1.putDouble(1.1D);
        byteBuffer1.putDouble(1.2D);
        byteBuffer1.putDouble(1.3D);
        byteBuffer1.putDouble(1.4D);
        byteBuffer1.flip();
        DoubleBuffer doubleBuffer = byteBuffer1.asDoubleBuffer();
        for(int i = 0; i < doubleBuffer.capacity(); i++){
            System.out.print(doubleBuffer.get() + " ");
        }
        System.out.println();

        ByteBuffer byteBuffer2 = ByteBuffer.allocate(16);
        byteBuffer2.putFloat(2.1F);
        byteBuffer2.putFloat(2.2F);
        byteBuffer2.putFloat(2.3F);
        byteBuffer2.putFloat(2.4F);
        byteBuffer2.flip();
        FloatBuffer floatBuffer = byteBuffer2.asFloatBuffer();
        for(int i = 0; i < floatBuffer.capacity(); i++){
            System.out.print(floatBuffer.get() + " ");
        }
        System.out.println();
    }
}
