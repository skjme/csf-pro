package cn.chaseshu.data.redis.cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 访问redis集群
 *
 */
public class JedisClusterTest {
    public static void main(String[] args) throws IOException {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 30001));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 30002));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 30003));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 30004));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 30005));
        jedisClusterNode.add(new HostAndPort("127.0.0.1", 30006));

        JedisCluster jedisCluster = null;
        try {
            //connectionTimeout：指的是连接一个url的连接等待时间
            //soTimeout：指的是连接上一个url，获取response的返回等待时间
            jedisCluster = new JedisCluster(jedisClusterNode, 6000, 5000, 10, config);
            System.out.println(jedisCluster.set("cluster", "haha"));
            System.out.println(jedisCluster.get("cluster"));
            System.out.println(jedisCluster.get("thing2"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedisCluster != null) {
                jedisCluster.close();
            }
        }
    }
}
