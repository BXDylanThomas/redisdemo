package com.dylan.service.impl;

import com.dylan.dao.StudentDao;
import com.dylan.model.Student;
import com.dylan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;


    @Cacheable(value = "redisCacheManager",key = "'getAll'")
    public List<Student> getStudent() {
        return studentDao.getStudent();
    }
}
