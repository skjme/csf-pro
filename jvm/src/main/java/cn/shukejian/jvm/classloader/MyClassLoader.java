package cn.shukejian.jvm.classloader;

//import cn.shukejian.jvm.Hello;

import com.sun.org.apache.regexp.internal.RE;
import sun.misc.Resource;
import sun.misc.URLClassPath;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessControlContext;
import java.security.AccessController;

/**
 * 自定义 类加载器 Class Loader
 */
public class MyClassLoader extends ClassLoader{
    
    /**
     * 采用 模板方法 设计模式
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // ....
        File file = new File("/Users/ask123/data", name.replace(".", "/").concat(".class"));
        if(!file.exists()){
            return super.loadClass(name);
        }
        try {
    
            final URL url = file.toURI().toURL();
    
            URL[] urls = new URL[1];
            urls[0] = url;
            URLClassPath path = new URLClassPath(urls);
            Resource res = path.getResource(name);
           
            final byte[] bytes1 = res.getBytes();
  
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos  = new ByteArrayOutputStream();
            int b = 0;
            
           
            
            while((b = fis.read()) != 0){
                String s = String.valueOf(b);
                System.out.println(s);
                baos.write(b);
            }
            
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
    
            return defineClass(name, bytes, 0, bytes.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyClassLoader cl = new MyClassLoader();
        Class<?> myClass = cl.loadClass("cn.shukejian.jvm.Hello");
//        Hello o = (Hello) myClass.newInstance();
//        o.print();
    
        Class<?> myClass2 = cl.loadClass("cn.shukejian.jvm.Hello");
        System.out.println(myClass2 == myClass);
    
        MyClassLoader cl2 = new MyClassLoader();
        Class myClass3 = cl2.loadClass("cn.shukejian.jvm.Hello");
        System.out.println(myClass3 == myClass);
    
    }
}
