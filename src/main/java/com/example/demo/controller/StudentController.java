package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final ServletContext servletContext;
    private final StudentService studentService;

    @GetMapping("/input-student")

    public String inputStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap modelMap) {
        System.out.println(request.getContextPath());
        System.out.println(session);
        System.out.println(modelMap);
        return "InputStudent";
    }

    @GetMapping("/students")
    public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap modelMap) {
        List<Student> students = studentService.allStudent();
        modelMap.addAttribute("students", students);
        return "student";
    }

    @PostMapping("/submit-students")
    @ResponseBody
    public Student index2(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
