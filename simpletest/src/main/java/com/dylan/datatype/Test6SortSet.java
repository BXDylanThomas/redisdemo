package com.dylan.datatype;

import redis.clients.jedis.Jedis;

public class Test6SortSet {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        jedis.select(5);
        jedis.flushDB();
        jedis.zadd("a",1.0,"a");
        jedis.zadd("a",2.0,"b");
        jedis.zadd("c",3,"a");
        jedis.zadd("d",4,"a");
    }
}
