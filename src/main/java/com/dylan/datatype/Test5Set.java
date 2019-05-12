package com.dylan.datatype;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Test5Set {
    public static void main(String[] args) {

        Jedis jedis=new Jedis("localhost",6379);

        jedis.select(4);

        jedis.sadd("set1","a","b","c","d");

        //移除元素
        jedis.srem("set1","a");

        //得到有多少元素
        System.out.println(jedis.scard("set1"));

        //得到集合元素
        Set<String> set1 = jedis.smembers("set1");
        System.out.println(set1);

        jedis.sadd("set2","a","b","c");

        //取交集
        Set<String> sinter = jedis.sinter("set1", "set2");
        System.out.println(sinter);

        //取到交集后，将其存取到数据库中
        jedis.sinterstore("set3","set1","set2");
    }
}
