package com.example.demo.controller;

import com.example.demo.SpringDemoApplication;
import com.example.demo.model.dto.Company;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import static java.nio.file.Files.copy;

//Hoc DI
@Controller
@RequiredArgsConstructor
@Log4j2
public class CompanyController {

    private final Company company;

    @GetMapping("/di")
    public String demoDI() {
        System.out.println("Print from controller " + company.getName());
        return "indexDI";
    }

    @PostMapping("/upload")
    public String uploadFile(ModelMap model, @RequestParam("image") MultipartFile image) {
        if (image.isEmpty()) {
            model.addAttribute("message", "Please insert file image");
        }
        Path path = Paths.get("images/");
        try {
            InputStream inputStream = image.getInputStream();
            Files.copy(inputStream, path.resolve(Objects.requireNonNull(image.getOriginalFilename())), StandardCopyOption.REPLACE_EXISTING);
            String filename = image.getOriginalFilename();
            log.info("Get an image " + filename);
            model.addAttribute("message", filename + " uploaded !!!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
        }
        return "indexDI";
    }
}
