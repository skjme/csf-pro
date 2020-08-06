package cn.shukejian.restclient.restlet;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.HashMap;

// 使用Restlet 调用REST 服务
public class Test {

    public static void main(String[] args) throws IOException {

        ClientResource clientResource = new ClientResource("http://localhost:9091/app?name=feign");

        Representation response = clientResource.get(MediaType.APPLICATION_JSON);

        JacksonRepresentation<HashMap> representation = new JacksonRepresentation<>(response, HashMap.class);

        HashMap map = representation.getObject();

        System.out.println(map);


    }
}
