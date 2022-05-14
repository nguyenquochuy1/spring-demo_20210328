package com.example.demo.service;

import com.example.demo.model.Weather;
import com.example.demo.repository.WeatherRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherService {


    private final WeatherRepository weatherRepository;

    public List<Weather> findAllWeatherData() {
        return weatherRepository.sellectAll();
    }


}
