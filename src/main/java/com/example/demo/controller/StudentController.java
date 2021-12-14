package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    ServletContext servletContext;

    @GetMapping("/student")
    public String index(HttpServletRequest request, HttpSession session, ModelMap modelMap) {

//        session.setAttribute("name","Nguyen Quoc Huy");
//        session.setAttribute("level","2");
//
//        request.setAttribute("name","Nguyen Van B");
//        request.setAttribute("level","4");
//
//        session.setAttribute("salary",1000);
//        request.setAttribute("photo","images/");
//
//        List<String> list = new ArrayList<>();
//        list.add("Nguyen Van A");
//        list.add("Nguyen Van C");
//
//        modelMap.addAttribute("list",list);

        Student student = new Student("1", 10.0, "IT");
        System.out.println(request.getQueryString());
        modelMap.addAttribute("student", student);

        return "student";
    }
}
