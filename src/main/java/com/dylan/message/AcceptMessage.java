package com.dylan.message;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class AcceptMessage {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6380);
        JedisPubSub myPub=new MyPub();
        jedis.subscribe(myPub,"cctv");
    }
    private static class MyPub extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {
            System.out.println("ÆµµÀ:"+channel+" ÏûÏ¢£º"+message);
        }
    }
}
