package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    @PostMapping("/demo")
    public String index(@RequestBody String request) {
        if (request.equals("hello")){
            return "ok";
        }
        return "hi";
    }
}
