package nio.buffer;

import java.nio.ByteBuffer;

public class TestBuffer8Clear {

	public static void main(String[] args) {
		// 8 clear 还原缓冲区的状态

		byte[] byteArray = new byte[]{1,2,3};

		ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);

		byteBuffer.position(2);
		byteBuffer.limit(3);
		byteBuffer.mark();

		System.out.println("byteBuffer.position=" + byteBuffer.position());
		System.out.println("byteBuffer.limit=" + byteBuffer.limit());
		System.out.println();

		byteBuffer.clear();

		System.out.println("调用 Buffer.clear() 后：");

		System.out.println("byteBuffer.position=" + byteBuffer.position());
		System.out.println("byteBuffer.limit=" + byteBuffer.limit());
		System.out.println();
		
	}

}
