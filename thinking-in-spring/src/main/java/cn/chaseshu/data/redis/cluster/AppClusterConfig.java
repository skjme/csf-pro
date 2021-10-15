package cn.chaseshu.data.redis.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class AppClusterConfig {

    public @Bean
    RedisConnectionFactory connectionFactory() {
    
        Collection<String> clusterNodes = new ArrayList<>();
        clusterNodes.add("127.0.0.1:30001");
        clusterNodes.add("127.0.0.1:30002");
        clusterNodes.add("127.0.0.1:30003");
        clusterNodes.add("127.0.0.1:30004");
        clusterNodes.add("127.0.0.1:30005");
        clusterNodes.add("127.0.0.1:30006");

        return new JedisConnectionFactory(
            new RedisClusterConfiguration(clusterNodes));
    }
}