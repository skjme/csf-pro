package cn.chaseshu.bean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() throws IOException {

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("META-INF/beanFactoryTest.xml"));

//        XmlBeanFactory xmlBeanFactory = (XmlBeanFactory)bf;
//        System.out.println(xmlBeanFactory.getBeanDefinition("myTestBean2"));

        MyTestBean myTestBean = (MyTestBean)bf.getBean("myTestBean2");
        Assert.assertEquals("testStr", myTestBean.getTestStr());
    }

    /**
     * 测试读取resource
     * @throws IOException
     */
    @Test
    public void testResource() throws IOException {
        Resource resource = new ClassPathResource("META-INF/beanFactoryTest.xml");
        InputStream inputStream = resource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char [] charArray = new char[1024];
        int readLength = inputStreamReader.read(charArray);
        while (readLength != -1){
            String newString = new String(charArray, 0, readLength);
            System.out.println(newString);
            readLength = inputStreamReader.read(charArray);
        }
        inputStreamReader.close();
        inputStream.close();
    }
}
