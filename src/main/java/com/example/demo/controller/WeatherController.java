package com.example.demo.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.WeatherService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public String demo(Model model) throws Exception {
        @NonNull
        List<Weather> weatherDataList = weatherService.findAllWeatherData();
        model.addAttribute("weatherDataList", weatherDataList);
        return "weather";
    }
}
