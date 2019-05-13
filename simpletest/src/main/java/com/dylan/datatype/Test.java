package com.dylan.datatype;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {

//        连接redis数据库实例
        Jedis jedis=new Jedis("localhost",6379);
        System.out.println(jedis.getDB());

        //切换库
        jedis.select(10);
        System.out.println(jedis.getDB());

        //情况当前库
        jedis.flushDB();
        jedis.flushAll();

        jedis.set("a","1");
        jedis.set("b","2");
        jedis.set("c","3");
        jedis.set("d","4");

        //得到所有的key
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            //输出可以  key-value
            System.out.println(key+"-->"+jedis.get(key));
        }

        //得到库中记录条数
        System.out.println(jedis.dbSize());


    }
}
