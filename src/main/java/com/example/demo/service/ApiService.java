package com.example.demo.service;

import com.example.demo.model.Weather;
import org.springframework.stereotype.Service;

@Service
public interface ApiService {
    Weather getCurrentWeather(String city);

    Weather getForecastWeather(String city, Integer numberOfDays);



}
