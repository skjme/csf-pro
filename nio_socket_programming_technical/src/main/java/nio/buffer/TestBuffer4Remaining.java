package nio.buffer;

import java.nio.CharBuffer;

public class TestBuffer4Remaining {

	public static void main(String[] args) {
		// 4 remaining 剩余空间的获取
		
		char[] charArray = new char[] {'a','b','c','d', 'e'};
			
		CharBuffer charBuffer = CharBuffer.wrap(charArray);
			
		System.out.println("A capacity() = " + charBuffer.capacity() + " limit() = " + charBuffer.limit()
				+ " position = " + charBuffer.position());
		System.out.println(charBuffer);
				
		charBuffer.position(2);
		
		System.out.println("B capacity() = " + charBuffer.capacity() + " limit() = " + charBuffer.limit()
				+ " position = " + charBuffer.position());
		System.out.println(charBuffer);
	
		System.out.println("C remaining() = " + charBuffer.remaining());
		
	}

}
