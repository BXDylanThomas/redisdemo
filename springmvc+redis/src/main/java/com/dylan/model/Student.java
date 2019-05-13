package com.dylan.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
