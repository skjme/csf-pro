package cn.shukejian.jvm.classloader;

import cn.shukejian.jvm.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

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
        try {
            
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos  = new ByteArrayOutputStream();
            int b = 0;
            
            while((b = fis.read()) != 0){
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
        ClassLoader cl = new MyClassLoader();
        Class<?> myClass = cl.loadClass("cn.shukejian.jvm.Hello");
        Hello o = (Hello) myClass.newInstance();
        o.print();
    
    }
}
