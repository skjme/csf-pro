package cn.chaseshu.thinking.in.spring.resource.springx;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

public class Handler extends sun.net.www.protocol.x.Handler {

    // 运行时 VM options 增加以下参数
    // -Djava.protocol.handler.pkgs=cn.chaseshu.thinking.in.spring.resource
    public static void main(String[] args) throws IOException {

        // springx 协议
        final URL url = new URL("springx:///META-INF/default.properties"); // 类似于classpath:///META-INF/default.properties
        InputStream inputStream = url.openStream();

        String s = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        System.out.println(s);

    }

}
