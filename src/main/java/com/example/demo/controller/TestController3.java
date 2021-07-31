package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController3 {
    @GetMapping("/index3")
    public String test(){
        return "/portfolio-details";
    }
}
