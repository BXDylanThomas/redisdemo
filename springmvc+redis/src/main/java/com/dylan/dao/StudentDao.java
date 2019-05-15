package com.dylan.dao;

import com.dylan.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudentDao {

    List<Student> getStudent();


}
