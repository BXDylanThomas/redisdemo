package com.dylan.message;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class SendMessage {

    public static void main(String[] args) {

        Jedis jedis=new Jedis("localhost",6380);
        jedis.publish("cctv","lalal");

    }

}
