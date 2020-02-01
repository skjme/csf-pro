package nio.buffer.bytebuffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class TestAsCharBuffer {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        byte[] byteArrayIn1 = "我是中国人".getBytes();// 默认编码utf-8
        byte[] byteArrayIn1 = "我是中国人".getBytes("utf-16BE");// 默认编码utf-8
        System.out.println(Charset.defaultCharset().name());

        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn1);
        System.out.println("byteBuffer=" + byteBuffer.getClass().getName());

        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        System.out.println("charBuffer=" + charBuffer.getClass().getName());

        System.out.println(byteBuffer);
        System.out.println(charBuffer);
        System.out.println(charBuffer.position() + " " + charBuffer.capacity() + " " + charBuffer.limit());
    }
}
