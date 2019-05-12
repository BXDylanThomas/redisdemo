package com.dylan.sentinel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * 哨兵
 */
public class JedisSentinel {
    public static void main(String[] args) {
        //创建哨兵对象
        Set<String> sen=new HashSet<String>();
        sen.add("127.0.0.1:26386");
        sen.add("127.0.0.1:26387");
        sen.add("127.0.0.1:26388");

        //创建哨兵池
        //第一个参数是  主库的名称  第二个参数是哨兵对象
        JedisSentinelPool jedisSentinelPool=new JedisSentinelPool("redis6380",sen);
        //从哨兵池得到数据库连接
        Jedis jedis = jedisSentinelPool.getResource();
        jedis.select(14);
        for (int i = 0; i < 1000; i++) {
            jedis.set(""+i,""+i);
        }
        //释放资源
        jedis.close();
        jedisSentinelPool.destroy();;

    }
}
