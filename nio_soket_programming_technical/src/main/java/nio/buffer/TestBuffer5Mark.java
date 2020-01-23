package nio.buffer;

import java.nio.CharBuffer;

public class TestBuffer5Mark {

	public static void main(String[] args) {
		// 5 mark 标记处理
		
		char[] charArray = new char[] {'a','b','c','d', 'e'};
			
		CharBuffer charBuffer = CharBuffer.wrap(charArray);
			
		System.out.println("A capacity() = " + charBuffer.capacity() + " limit() = " + charBuffer.limit()
				+ " position = " + charBuffer.position());
		System.out.println(charBuffer);
				
		charBuffer.position(1);
		charBuffer.mark(); // 在位置1设置mark
		
		System.out.println(" position = " + charBuffer.position());

		charBuffer.position(2); // 改变位置
		
		System.out.println(" position = " + charBuffer.position());
		
		charBuffer.reset(); // 位置重置
		
		System.out.println(" position = " + charBuffer.position());
	
		
	}

}
