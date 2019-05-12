package com.dylan.tranalation;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class Tralation {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        jedis.select(8);
        jedis.flushDB();

        jedis.set("xiaoming","2000");
        jedis.set("wangwu","5000");

        //С��������ת��1000Ԫ����� С��1000  ����6000
        int money=1000;

        /**
         * ��أ�
         *      �����ڼ��֮�������ύ֮ǰ��
         *      �Լ�صĶ���������޸ģ�������Ͳ�ִ���ύ
         */
        jedis.watch("xiaoming","wangwu");
        jedis.set("xiaoming","3000");
        Transaction multi = jedis.multi();//�õ��������
        multi.incrBy("wangwu",money);
        multi.decrBy("xiaoming",money);
        List<Object> exec = multi.exec();//�ύ����
        jedis.unwatch();

        if(exec.isEmpty()){
            System.out.println("����ʧ��");
        }else{
            System.out.println("����ɹ�");
        }
        System.out.println(jedis.get("xiaoming")+"  "+jedis.get("wangwu"));
    }
}
