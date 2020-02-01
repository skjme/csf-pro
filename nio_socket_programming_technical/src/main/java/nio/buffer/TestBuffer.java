package nio.buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class TestBuffer {

    // 1 测试Buffer缓冲区的capacity、limit、position不能为负数
    // 如果是负数 则抛出IllegalArgumentException
    public static void testNonNegativeInteger(){

        // Capacity 容量大小测试
        try{
            CharBuffer byteBuffer = CharBuffer.allocate(-1);
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
            System.out.println("CharBuffer缓冲区的capacity容量大小不能为负数");
        }

        // Limit
        try{
            char[] charArray = new char[] {'a','b','c','d','e'};

            CharBuffer charBuffer = CharBuffer.wrap(charArray);

            charBuffer.limit(-1);

        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
            System.out.println("CharBuffer缓冲区的limit不能为负数");
        }

        // Position
        try{
            char[] charArray = new char[] {'a','b','c','d','e'};

            CharBuffer charBuffer = CharBuffer.wrap(charArray);

            charBuffer.position(-1);

        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
            System.out.println("CharBuffer缓冲区的position不能为负数");
        }

    }

    // 2 验证position不能大于其limit, limit 不能大于capacity

    public static void testPositionAndLimit(){

        byte[] byteArray = new byte[]{1,2,3,4};

        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);

       // The new limit value; must be non-negative  and no larger than this buffer's capacity
        byteBuffer.limit(2); // ok
//        byteBuffer.limit(100); // throw IllegalArgumentException

        System.out.println(byteBuffer.limit());
        // The new position value; must be non-negative and no larger than the current limit
//        byteBuffer.position(2); // it is ok
        byteBuffer.position(3); // throw IllegalArgumentException

    }

    /**
     * 如果定义了mark，则在将position或limit调整为小于该mark的值时，该mark被丢弃。
     */
    public static void testMark(){
        byte[] byteArray = new byte[]{1,2,3};

        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);

        byteBuffer.position(1);
        byteBuffer.mark();

        System.out.println("byteBuffer 在 " + byteBuffer.position()+ " 位置设置mark标记");

        byteBuffer.position(2);

        byteBuffer.reset();

        System.out.println("byteBuffer 在 " + byteBuffer.position()+ " 位置设置mark标记");


        // position调整小于该mark
        byteBuffer.position(2);
        byteBuffer.mark();
        byteBuffer.position(1);
//        byteBuffer.reset(); // 抛出InvalidMarkException


        byteBuffer.position(2);
        byteBuffer.mark();
        System.out.println("position = " + byteBuffer.position() + ", limit = " + byteBuffer.limit());
        byteBuffer.position(3);
        byteBuffer.limit(3);
        System.out.println("position = " + byteBuffer.position() + ", limit = " + byteBuffer.limit());
        byteBuffer.reset();
        System.out.println("position = " + byteBuffer.position() + ", limit = " + byteBuffer.limit());

        // limit < mark, thow InvalidMarkException
        byteBuffer.position(2);
        byteBuffer.mark(); // mark value is 2
        byteBuffer.limit(1);
        byteBuffer.reset();//


    }

    // 如果position大于新的limit，则position的值就是新的limit的值
    public static void testPositionByLimit(){
        byte[] byteArray = new byte[]{1,2,3};

        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println("position = " + byteBuffer.position() + ", limit = " + byteBuffer.limit());

        byteBuffer.position(3);
        System.out.println("position = " + byteBuffer.position() + ", limit = " + byteBuffer.limit());

        byteBuffer.limit(2);
        System.out.println("position = " + byteBuffer.position() + ", limit = " + byteBuffer.limit());

        // 当limit与position值一样时，在指定的position写入数据时会出现异常BufferOverflowException
        byteBuffer.position(1);
        byteBuffer.limit(1);
        byteBuffer.put((byte) 4); // throw BufferOverflowException


    }

    public static void main(String[] args) {
//        testNonNegativeInteger();

//        testPositionAndLimit();

//        testMark();

        testPositionByLimit();
    }

}
