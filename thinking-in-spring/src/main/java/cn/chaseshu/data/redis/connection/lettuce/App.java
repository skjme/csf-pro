package cn.chaseshu.data.redis.connection.lettuce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class App {
    
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    
        context.register(AppConfig.class);
    
        context.refresh();
    
        LettuceConnectionFactory connectionFactory = context.getBean(LettuceConnectionFactory.class);
    
        RedisTemplate<String, String> template = new RedisTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
//        template.setEnableDefaultSerializer(true);
        template.afterPropertiesSet();
    
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set("k1", "hello");
        System.out.println(ops.get("k1"));
        
    
        context.close();
    }
}