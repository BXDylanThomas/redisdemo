package com.dylan.datatype;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {

//        ����redis���ݿ�ʵ��
        Jedis jedis=new Jedis("localhost",6379);
        System.out.println(jedis.getDB());

        //�л���
        jedis.select(10);
        System.out.println(jedis.getDB());

        //�����ǰ��
        jedis.flushDB();
        jedis.flushAll();

        jedis.set("a","1");
        jedis.set("b","2");
        jedis.set("c","3");
        jedis.set("d","4");

        //�õ����е�key
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            //�������  key-value
            System.out.println(key+"-->"+jedis.get(key));
        }

        //�õ����м�¼����
        System.out.println(jedis.dbSize());


    }
}
