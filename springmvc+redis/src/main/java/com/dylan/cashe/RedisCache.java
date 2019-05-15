package com.dylan.cashe;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


@Component
public class RedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    @Autowired
    private static JedisConnectionFactory jedisConnectionFactory;

    private String id;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(String id) {
        if(id== null){
            throw  new IllegalArgumentException("cache instaces require an id");
        }
        logger.debug("MyBatisRedisCacheID:"+id);
        this.id = id;
    }


    public String getId() {
        return this.id;
    }

    public void putObject(Object key, Object value) {
        RedisConnection connection=null;
        try{
            connection=jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer=new JdkSerializationRedisSerializer();
            connection.set(serializer.serialize(key),serializer.serialize(value));
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if(connection!=null) connection.close();
        }
    }

    public Object getObject(Object key) {
        Object result=null;
        RedisConnection redisConnection=null;
        try{
            redisConnection=jedisConnectionFactory.getConnection();
            RedisSerializer<Object> redisSerializer=new JdkSerializationRedisSerializer();
            result=redisSerializer.deserialize(redisConnection.get(redisSerializer.serialize(key)));
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if (redisConnection!=null) redisConnection.close();
        }
        return result;
    }

    /**
     *ÉèÖÃkey¹ýÆÚ
     */
    public Object removeObject(Object key) {
        Object result=null;
        RedisConnection redisConnection=null;
        try{
            redisConnection=jedisConnectionFactory.getConnection();
            RedisSerializer<Object> redisSerializer=new JdkSerializationRedisSerializer();
            result=redisConnection.expire(redisSerializer.serialize(key),0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(redisConnection!=null) redisConnection.close();
        }
        return result;
    }

    public void clear() {

        RedisConnection redisConnection=null;
        try{
            redisConnection=jedisConnectionFactory.getConnection();
            redisConnection.flushDb();
            redisConnection.flushAll();
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if(redisConnection!=null){
                redisConnection.close();
            }
        }

    }

    public int getSize() {
        int result=0;
        RedisConnection redisConnection=null;
        try{
            redisConnection=jedisConnectionFactory.getConnection();
            result=Integer.valueOf(redisConnection.dbSize().toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(redisConnection !=null) redisConnection.close();
        }
        return result;
    }

    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }
}
