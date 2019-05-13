package com.dylan.datatype;

import redis.clients.jedis.Jedis;

import java.util.List;

public class Test4List {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        jedis.select(2);
        //list������һ��˫���б�

        //�������
        jedis.lpush("list-1","1","2","3");
        //���Ҳ���
        jedis.rpush("list-1","4","5","6");

        //�����ȡ��һ������
        String lpop = jedis.lpop("list-1");
        System.out.println(lpop);


        //����
        List<String> lrange = jedis.lrange("list-1", 0, -1);
        System.out.println(lrange);


    }
}
