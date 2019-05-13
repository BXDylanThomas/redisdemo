package com.dylan.service.impl;

import com.dylan.dao.StudentDao;
import com.dylan.model.Student;
import com.dylan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;



    public Student getStudent() {
        return studentDao.getStudent();
    }
}
