package com.dylan.datatype;

import redis.clients.jedis.Jedis;

public class Test2 {

    public static void main(String[] args) {

        Jedis jedis=new Jedis("localhost",6379);

        jedis.set("a","1");
        jedis.append("a","2");
        System.out.println(jedis.get("a"));
        //从某处set值
        jedis.setrange("a",1,"3");
        System.out.println(jedis.get("a"));

        //每次调用自增1
        jedis.incr("a");
        System.out.println(jedis.get("a"));
        jedis.incrBy("a",10);
        System.out.println(jedis.get("a"));

        jedis.decr("a");
        System.out.println(jedis.get("a"));
        jedis.decrBy("a",5);
        System.out.println(jedis.get("a"));

    }
}
