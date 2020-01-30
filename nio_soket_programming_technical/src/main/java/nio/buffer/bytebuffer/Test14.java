package nio.buffer.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Test14 {

    public static void main(String[] args) {

        // 设置与获得字节顺序
//        ByteOrder.BIG_ENDIAN  从最高有效位到最低有效位
//        ByteOrder.LITTLE_ENDIAN; 反之


        int value = 123456789;
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
        System.out.println(byteBuffer1.order());
        System.out.println(byteBuffer1.order());
        byteBuffer1.putInt(value);
        byte[] byteArray = byteBuffer1.array();
        for(int i = 0; i < byteArray.length; i++){
            System.out.print(byteArray[i] + " ");
        }
        System.out.println();
        System.out.println();

        byteBuffer1 = ByteBuffer.allocate(4);
        System.out.println(byteBuffer1.order());
        byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(byteBuffer1.order());
        byteBuffer1.putInt(value);
        byteArray = byteBuffer1.array();
        for(int i = 0; i < byteArray.length; i++){
            System.out.print(byteArray[i] + " ");
        }
        System.out.println();
        System.out.println();


        // 如果字节顺序不一致，获取数据会出错
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.putInt(123);
        byteBuffer.putInt(456);
        byteBuffer.flip();
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getInt());

        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteBuffer.array());
        byteBuffer2.order(ByteOrder.LITTLE_ENDIAN); // 字节顺序不一致
        System.out.println(byteBuffer2.getInt());
        System.out.println(byteBuffer2.getInt());

    }
}
