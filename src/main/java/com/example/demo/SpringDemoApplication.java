package com.example.demo;

import com.example.demo.model.dto.Company;
import com.example.demo.model.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext content = SpringApplication.run(SpringDemoApplication.class, args);
        Company company = (Company) content.getBean("company");
        System.out.println("Company : " + company.getName());
    }

    @Bean(name = "company")
    public Company getCompany() {
        Company company = new Company();
        company.setName("It-Web");
        company.setLogo("It-logo");
        return company;
    }

    @Bean
    User getUser() {
        return new User("HuyNQ", "avc");
    }

}
