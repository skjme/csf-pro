package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;

/**
 * getType putType
 */
public class Test6 {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.putChar('a'); // 0-1, char占2个字节
        byteBuffer.putChar(2, 'b');

        System.out.println(byteBuffer);

        byteBuffer.position(4);
        byteBuffer.putDouble(1.1); // 4-11, double 占8个字节
        byteBuffer.putDouble(12, 1.2); //  12-19

        System.out.println(byteBuffer);

        byteBuffer.position(20);
        byteBuffer.putFloat(2.1f); // 20-23, float占四个字节
        byteBuffer.putFloat(24, 2.2f); // 24-27

        byteBuffer.position(28);
        byteBuffer.putInt(31); // 28-31, int 占4个字节
        byteBuffer.putInt(32, 32);// 32-35

        // long 占8个字节
        byteBuffer.position(36);
        byteBuffer.putLong(41L); // 36-43
        byteBuffer.putLong(44, 42L); // 44-51

        // short 占2个字节
        byteBuffer.position(52);
        byteBuffer.putShort((short)51); //52-53
        byteBuffer.putShort(54, (short)52); //54-55


        byteBuffer.position(0);

        byte[] byteArrayOut = byteBuffer.array();
        for(int i = 0; i < byteArrayOut.length; i++){
//            System.out.print(byteArrayOut[i] + " ");
        }

        System.out.println();
        System.out.println(byteBuffer.getChar());
//        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getChar(2));

        byteBuffer.position(4);
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getDouble(12));

        byteBuffer.position(20);
        System.out.println(byteBuffer.getFloat());
        System.out.println(byteBuffer.getFloat(24));

        byteBuffer.position(28);
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getInt(32));

        byteBuffer.position(36);
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getLong(44));

        byteBuffer.position(52);
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getShort(54));

    }
}
