package com.example.demo.controller;

import com.example.demo.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final User user;

    @GetMapping("/home2")
    public String home() {
        return "home";
    }

    @ModelAttribute("user")
    public User getUser() {
        return user;
    }

}
