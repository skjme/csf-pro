package cn.chaseshu.thinking.in.spring.resource.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

public interface ResourceUtils {

    static String getContent(Resource resource){
        try{
            return getContent(resource, "UTF-8");
        }catch (Exception ex){
            return ex.toString();
        }
    }
    static String getContent(Resource resource, String encode) throws IOException {
        EncodedResource encodedResource = new EncodedResource(resource, encode);
        try (Reader reader = encodedResource.getReader()) {
            return IOUtils.toString(reader);
        }

    }
}
