package com.example.demo.controller;

import com.example.demo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController2 {
    @GetMapping("/add")
    public String addStudent(ModelMap model) {
        Student student = new Student();
        student.setId(1);
        student.setName("huy");
        student.setMark(9.0);
        student.setMajor("IT");
        model.addAttribute(student);
        return "student3";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute ModelMap model, Student student) {
        Student stu = new Student();
        model.addAttribute(stu);
        log.info(String.valueOf(student.getName()));
        return "student3";
    }
}
