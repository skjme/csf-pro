package javase.encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) throws IOException {
        //https://www.baeldung.com/java-char-encoding
        System.out.println(Charset.defaultCharset().displayName());
        System.out.println(Charset.defaultCharset().displayName(Locale.CHINA));


        byte[] bytes = "hello".getBytes(Charset.defaultCharset());
        System.out.println(bytes);
        System.out.println(new String(bytes, 0, bytes.length));

        System.out.println(decodeText("hello", "utf-8"));
        System.out.println(decodeText("hello", "utf-16"));
        System.out.println(decodeText("hello", "US-ASCII"));
        System.out.println(decodeText("hello", "gbk"));
        System.out.println(convertToBinary("你", "utf-8"));


    }

    static String decodeText(String input, String encoding) throws IOException {
        return
                new BufferedReader(
                        new InputStreamReader(
                                new ByteArrayInputStream(input.getBytes()),
                                Charset.forName(encoding)))
                        .readLine();
    }

    static String convertToBinary(String input, String encoding)
            throws UnsupportedEncodingException {
        byte[] encoded_input = Charset.forName(encoding)
                .encode(input)
                .array();
        return IntStream.range(0, encoded_input.length)
                .map(i -> encoded_input[i])
                .mapToObj(e -> Integer.toBinaryString(e ^ 255))
                .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
                .collect(Collectors.joining(" "));
    }
}
