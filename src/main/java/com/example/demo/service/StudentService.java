package com.example.demo.service;


import com.example.demo.model.Student;
import com.example.demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentsRepository studentsRepository;
    Student student;

    //    StudentsRepository studentsRepository = new StudentsRepository();
    public Student createStudent(Student student) {
        studentsRepository.save(student);
        this.student = student;
        return this.student;
    }

    public List<Student> allStudent() {
        return studentsRepository.findAll();
    }

}
