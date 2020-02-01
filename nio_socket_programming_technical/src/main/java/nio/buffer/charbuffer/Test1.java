package nio.buffer.charbuffer;

import java.nio.CharBuffer;

public class Test1 {

    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(15);
        System.out.println(charBuffer.position());
        charBuffer.append('a');
        System.out.println(charBuffer.position());
        charBuffer.append("bcdefg");
        System.out.println(charBuffer.position());
        charBuffer.append("abchijklmn", 3, 8);
        System.out.println(charBuffer.position());

        char[] chars = charBuffer.array();
        for (int i = 0; i < chars.length; i++){
            System.out.print(chars[i] + " ");
        }
        System.out.println();

        System.out.println(charBuffer.capacity());

    }
}
