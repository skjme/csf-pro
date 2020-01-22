package nio.buffer;

import java.nio.CharBuffer;

public class TestBuffer3Position {

	public static void main(String[] args) {
		// 3 position 位置获取与设置
		
		char[] charArray = new char[] {'a','b','c','d'};
			
		CharBuffer charBuffer = CharBuffer.wrap(charArray);
			
		System.out.println("A capacity() = " + charBuffer.capacity() + " limit() = " + charBuffer.limit()
				+ " position = " + charBuffer.position());
		System.out.println(charBuffer);
				
		charBuffer.position(2);
		
		System.out.println("A capacity() = " + charBuffer.capacity() + " limit() = " + charBuffer.limit()
				+ " position = " + charBuffer.position());
		
		charBuffer.put('z');
		System.out.println(charBuffer);
		
		for(int i = 0; i < charArray.length; i++){
			System.out.print(charArray[i] + " ");
		}
		
	}

}
