package cn.shukejian.restclient.cxf;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

//使用CXF 调用REST 服务
// 注意： jdk >= jdk9 报一下错误：
// java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
public class Test {

    public static void main(String[] args) throws IOException {

        WebClient webClient = WebClient.create("http://localhost:9091/app?name=feign");

        Response response = webClient.get();

        InputStream ent  = (InputStream) response.getEntity();
        String s = IOUtils.readStringFromStream(ent);

        System.out.println(s);
    }

}
