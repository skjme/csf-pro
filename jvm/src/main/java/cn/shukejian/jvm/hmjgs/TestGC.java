package cn.shukejian.jvm.hmjgs;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * -XX:+UseSerialGC
 * 指定年轻代和老年代都使用串行垃圾收集器
 * -XX:+PrintGCDetails
 * 打印垃圾回收的详细信息
 *
 * add vm options:
 * -XX:+UseSerialGC -XX:+PrintGCDetails -Xms16m -Xmx16m
 */
public class TestGC {
 
    public static void main(String[] args) throws Exception {
        List<Object> list = new ArrayList<Object>();
        while (true){
            int sleep = new Random().nextInt(100);
            if(System.currentTimeMillis() % 2 ==0){
                list.clear();
            }else{
                for (int i = 0; i < 10000; i++) {
                    Properties properties = new Properties();
                    properties.put("key_"+i, "value_" + System.currentTimeMillis() + i);
                    list.add(properties);
                }
            }
 
            System.out.println("list大小为：" + list.size());
 
            Thread.sleep(sleep);
        }
    }
}