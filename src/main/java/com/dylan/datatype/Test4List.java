package com.dylan.datatype;

import redis.clients.jedis.Jedis;

import java.util.List;

public class Test4List {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        jedis.select(2);
        //list类型是一个双向列表

        //从左插入
        jedis.lpush("list-1","1","2","3");
        //从右插入
        jedis.rpush("list-1","4","5","6");

        //从左边取走一个数据
        String lpop = jedis.lpop("list-1");
        System.out.println(lpop);


        //遍历
        List<String> lrange = jedis.lrange("list-1", 0, -1);
        System.out.println(lrange);


    }
}
