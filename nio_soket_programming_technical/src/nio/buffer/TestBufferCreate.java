package nio.buffer;

import java.nio.ByteBuffer;

/**
 * 实例化Buffer子类，ByteBuffer/ShortBuffer/IntBuffer/LongBuffer/FloatBuffer/DoubleBuffer/CharBuffer
 * @author chase.shu
 * @since 2020.01.22
 *
 */
public class TestBufferCreate {

	public static void main(String[] args) {
		
		// 1 包装数据和获取容量
		// 通过wrap来实例化 ，本质是通过创建HeapByteBuffer类的实例来创建ByteBuffer类的实例
		
		byte[] byteArray = new byte[]{1,2,3};
		
		ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
		
		System.out.println(byteBuffer.getClass().getName());
		
		System.out.println(byteBuffer.capacity());
		
		System.out.println();
	}
}
