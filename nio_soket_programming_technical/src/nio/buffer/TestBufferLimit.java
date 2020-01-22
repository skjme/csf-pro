package nio.buffer;

import java.nio.CharBuffer;

public class TestBufferLimit {

	public static void main(String[] args) {
		// 2 limit 限制获取与设置
		
		char[] charArray = new char[] {'a','b','c','d','e'};
			
		CharBuffer charBuffer = CharBuffer.wrap(charArray);
			
		System.out.println("A capacity() = " + charBuffer.capacity() + " limit() = " + charBuffer.limit());
		System.out.println(charBuffer);
		
		charBuffer.limit(3);
		
		System.out.println();
		
		System.out.println("B capacity() = " + charBuffer.capacity() + " limit() = " + charBuffer.limit());
		System.out.println(charBuffer);
		
		charBuffer.put(0, 'o');
		charBuffer.put(1, 'p');
		charBuffer.put(2, 'q');
		charBuffer.put(3, 'r'); // 此位置是第一个不可读不可写的索引
		charBuffer.put(4, 's');
		charBuffer.put(5, 't');
		charBuffer.put(6, 'u');
		
		System.out.println(charBuffer);


	}

}
