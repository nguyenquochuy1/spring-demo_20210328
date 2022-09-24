package com.example.demo.service;

import com.example.demo.model.entity.Weather;
import com.example.demo.repository.WeatherRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {


    private final WeatherRepository weatherRepository;
    @NonNull
    public List<Weather> findAllWeatherData() {
        return weatherRepository.sellectAll();
    }


}
