package cn.chaseshu.j2cache.test;

import net.oschina.j2cache.*;


public class Test {

    public static void main(String[] args) {
        test();
//        test2();
    }

    public static void test() {

        CacheChannel cache = J2Cache.getChannel();

        cache.set("default", "1", "hello j2cache");

        CacheObject aDefault = cache.get("default", "1");
        System.out.println(aDefault);

    }


    public static void test2(){
        J2CacheConfig config = new J2CacheConfig();
        //填充 config 变量所需的配置信息
        J2CacheBuilder builder = J2CacheBuilder.init(config);
        CacheChannel channel = builder.getChannel();
        //进行缓存的操作
        channel.close();
    }
}
