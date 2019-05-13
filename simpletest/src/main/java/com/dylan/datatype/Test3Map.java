package com.dylan.datatype;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test3Map {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        //一次set多个值
        jedis.select(10);
        jedis.mset("a","1","b","2");
        System.out.println(jedis.keys("*"));

        jedis.select(11);
        HashMap<String,String> map=new HashMap<String, String>();

        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        jedis.hmset("map",map);
        System.out.println(jedis.hlen("map"));

        jedis.hset("map","d","4");

        Set<String> map1 = jedis.hkeys("map");

        Map<String, String> map2 = jedis.hgetAll("map");

    }
}
