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

        //小明给王五转账1000元，结果 小明1000  王五6000
        int money=1000;

        /**
         * 监控：
         *      若果在监控之后，事务提交之前，
         *      对监控的对象进行了修改，则事务就不执行提交
         */
        jedis.watch("xiaoming","wangwu");
        jedis.set("xiaoming","3000");
        Transaction multi = jedis.multi();//得到事务对象
        multi.incrBy("wangwu",money);
        multi.decrBy("xiaoming",money);
        List<Object> exec = multi.exec();//提交事务
        jedis.unwatch();

        if(exec.isEmpty()){
            System.out.println("插入失败");
        }else{
            System.out.println("插入成功");
        }
        System.out.println(jedis.get("xiaoming")+"  "+jedis.get("wangwu"));
    }
}
