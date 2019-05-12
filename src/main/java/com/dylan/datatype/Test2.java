package com.dylan.datatype;

import redis.clients.jedis.Jedis;

public class Test2 {

    public static void main(String[] args) {

        Jedis jedis=new Jedis("localhost",6379);

        jedis.set("a","1");
        jedis.append("a","2");
        System.out.println(jedis.get("a"));
        //��ĳ��setֵ
        jedis.setrange("a",1,"3");
        System.out.println(jedis.get("a"));

        //ÿ�ε�������1
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
