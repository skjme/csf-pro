package cn.chaseshu.data.redis;

import redis.clients.jedis.util.JedisClusterCRC16;

/**
 * redis分片算法
 *
 */
public class CRC16 {

    public static void main(String[] args){
        String str="hello";
        System.out.println(JedisClusterCRC16.getCRC16(str)%16384);
    }
    
}
