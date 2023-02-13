package com.example.demo.impl;

import com.example.demo.model.Weather;
import com.example.demo.service.ApiService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
@Getter
@Setter
@Service
@Slf4j
public class ApiServiceImpl implements ApiService {

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private HttpHeaders httpHeaders ;

    public Weather getCurrentWeather(String city) {
        String api = "http://api.weatherapi.com/v1/current.json?key=df307239d0664658b8e141833230602&q={city}&aqi=no";
        api = api.replace("{city}",city);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Weather> response = restTemplate.exchange(api, HttpMethod.GET, entity, Weather.class);
        return response.getBody();
    }

    @Override
    public Weather getForecastWeather(String city, Integer numberOfDays) {
        String api = "http://api.weatherapi.com/v1/forecast.json?key=df307239d0664658b8e141833230602&q&q={city}&days={days}&aqi=no&alerts=no";
        api = api.replace("{city}",city);
        api = api.replace("{days}",String.valueOf(numberOfDays));
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Weather> response = restTemplate.exchange(api, HttpMethod.GET, entity, Weather.class);
        return response.getBody();
    }


}
