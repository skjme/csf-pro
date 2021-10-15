package cn.chaseshu.data.redis.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class ApplicationConfig {

  @Bean
  public RedisConnectionFactory connectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

    RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }
}