package nio.buffer;

import java.nio.ByteBuffer;

public class TestBuffer7Direct {

	public static void main(String[] args) {
		// 7 直接缓冲区， 增加程序运行效率，无需JVM创建新的缓冲区（中间缓冲区）

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
		System.out.println(byteBuffer.isDirect());

	
		
	}

}
