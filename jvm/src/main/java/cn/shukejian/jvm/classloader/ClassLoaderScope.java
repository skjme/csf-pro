package cn.shukejian.jvm.classloader;

public class ClassLoaderScope {
    
    public static void main(String[] args) {
        
        // BootstrapClassLoader c/c++ impl
        String boostrap = System.getProperty("sun.boot.class.path");
        System.out.println("\nsun.boot.class.path:\n" +
                boostrap.replaceAll(":", System.lineSeparator()));
    
        // ExtClassLoader
        String ext = System.getProperty("java.ext.dirs");
        System.out.println("\njava.ext.dirs:\n" +
                ext.replaceAll(":", System.lineSeparator()));
    
        // AppClassLoader
        String s = System.getProperty("java.class.path");
        System.out.println("\njava.class.path:\n" +
                s.replaceAll(":", System.lineSeparator()));
    }
    
    public void test(){
        System.out.println("Hello!");
    }
}
