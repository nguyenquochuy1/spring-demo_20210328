package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController2 {
    @GetMapping("/index2")
    public String test(){
        return "/inner-page";
    }
}
