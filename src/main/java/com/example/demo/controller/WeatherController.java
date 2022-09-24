package com.example.demo.controller;

import com.example.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/weather")
    public String demo(Model model) throws Exception {
        List<Weather1> weatherDataList = weatherService.findAllWeatherData();
        model.addAttribute("weatherDataList", weatherDataList);
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("select  * from weather");
//        model.addAttribute("weatherDataList", list);
        return "weather";
    }

    @PostMapping("/weather")
    public List<Weather1> getListWeather() throws Exception {
        return weatherService.findAllWeatherData();
    }
}
