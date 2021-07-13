package cn.chaseshu.thinking.in.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @see FileSystemResource
 * @see EncodedResource
 */
public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) throws IOException {

        String currentJavaFilePath = System.getProperty("user.dir") + "/src/main/java/cn/chaseshu/thinking/in/spring/resource/EncodedFileSystemResourceLoaderDemo.java";

        System.out.println(currentJavaFilePath);

        File file = new File(currentJavaFilePath);
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");

        System.out.println(encodedResource);
        Reader reader = encodedResource.getReader();
        String s = IOUtils.toString(reader);
        System.out.println(s);


    }
}
