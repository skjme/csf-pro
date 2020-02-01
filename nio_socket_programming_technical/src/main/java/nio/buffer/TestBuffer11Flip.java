package nio.buffer;

import java.nio.ByteBuffer;

public class TestBuffer11Flip {

	public static void main(String[] args) {
		// 11 flip  反转缓冲区 limit => position position => 0

		byte[] byteArray = new byte[]{1,2,3};

		ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);

		byteBuffer.position(2);
		byteBuffer.mark();

		System.out.println("byteBuffer.position=" + byteBuffer.position());
		System.out.println("byteBuffer.limit=" + byteBuffer.limit());
		System.out.println();

		byteBuffer.flip();

		System.out.println("byteBuffer.position=" + byteBuffer.position());
		System.out.println("byteBuffer.limit=" + byteBuffer.limit());
		System.out.println();
		try{
			byteBuffer.reset();
		}catch (Exception ex){
			ex.printStackTrace();
			System.out.println("bytebuffer mark 丢失");
		}

		
	}

}
