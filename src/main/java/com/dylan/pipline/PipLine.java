package com.dylan.pipline;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.Date;

public class PipLine {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        jedis.select(0);
        jedis.flushDB();
        Pipeline pipLine=jedis.pipelined();
        Date date1=new Date();
        for (int i = 0; i <= 10000000; i++) {
//            jedis.set(""+i,""+i);
            pipLine.hset("key_"+i,"key_"+i,""+i);
        }
        pipLine.sync();
        Date date2=new Date();

        System.out.println((date2.getTime()-date1.getTime())/1000);
    }
}
