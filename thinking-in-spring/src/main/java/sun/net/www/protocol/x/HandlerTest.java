package sun.net.www.protocol.x;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * 通过Java标准资源管理扩展协议方式实现
 */
public class HandlerTest {

    public static void main(String[] args) throws IOException {
        final URL url = new URL("x:///META-INF/default.properties"); // 类似于classpath:///META-INF/default.properties
        InputStream inputStream = url.openStream();

        String s = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        System.out.println(s);

    }
}
