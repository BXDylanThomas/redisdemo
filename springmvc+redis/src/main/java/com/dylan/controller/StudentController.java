package com.dylan.controller;

import com.dylan.model.Student;
import com.dylan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public String to(Model model){
        Student student = studentService.getStudent().get(0);
        model.addAttribute("ssss",student);
        return "aa";
    }

    public void test(){

    }
}
