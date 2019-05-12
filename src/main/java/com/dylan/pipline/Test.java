package com.dylan.pipline;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        jedis.select(9);

        Set<String> keys = jedis.keys("*");
        List list=new ArrayList(keys);

        for(int i=0;i<10000;i++){
           if(!list.contains(""+i)){
               System.out.println(i);
           }
        }

    }
}
