package com.dylan.sentinel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * �ڱ�
 */
public class JedisSentinel {
    public static void main(String[] args) {
        //�����ڱ�����
        Set<String> sen=new HashSet<String>();
        sen.add("127.0.0.1:26386");
        sen.add("127.0.0.1:26387");
        sen.add("127.0.0.1:26388");

        //�����ڱ���
        //��һ��������  ���������  �ڶ����������ڱ�����
        JedisSentinelPool jedisSentinelPool=new JedisSentinelPool("redis6380",sen);
        //���ڱ��صõ����ݿ�����
        Jedis jedis = jedisSentinelPool.getResource();
        jedis.select(14);
        for (int i = 0; i < 1000; i++) {
            jedis.set(""+i,""+i);
        }
        //�ͷ���Դ
        jedis.close();
        jedisSentinelPool.destroy();;

    }
}
