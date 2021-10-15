package cn.chaseshu.data.redis.cluster;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class App {
    
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        
        context.register(AppClusterConfig.class);
        
        context.refresh();
        
        RedisConnectionFactory connectionFactory = context.getBean(RedisConnectionFactory.class);
    
        RedisClusterConnection connection = connectionFactory.getClusterConnection();
//        connection.set("thing1".getBytes(), "value1".getBytes());
//        connection.set("thing2".getBytes(), "value2".getBytes());
        
        byte[] bytes = connection.get("thing2".getBytes());
        System.out.println(new String(bytes));
    
        connection.keys("*".getBytes()).stream().forEach( v->System.out.println(String.valueOf(v)));
        System.out.println(new String[]{});
        
        context.close();
    }
}
