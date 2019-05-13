package com.dylan.datatype;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Test5Set {
    public static void main(String[] args) {

        Jedis jedis=new Jedis("localhost",6379);

        jedis.select(4);

        jedis.sadd("set1","a","b","c","d");

        //�Ƴ�Ԫ��
        jedis.srem("set1","a");

        //�õ��ж���Ԫ��
        System.out.println(jedis.scard("set1"));

        //�õ�����Ԫ��
        Set<String> set1 = jedis.smembers("set1");
        System.out.println(set1);

        jedis.sadd("set2","a","b","c");

        //ȡ����
        Set<String> sinter = jedis.sinter("set1", "set2");
        System.out.println(sinter);

        //ȡ�������󣬽����ȡ�����ݿ���
        jedis.sinterstore("set3","set1","set2");
    }
}
