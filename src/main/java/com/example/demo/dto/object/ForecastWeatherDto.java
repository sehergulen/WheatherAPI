package com.example.demo.dto.object;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ForecastWeatherDto {
    List<DailyWeatherDto> dailyWeatherDtos;
    String forecastType;


    @Override
    public String toString() {
        return "{" +
                forecastType+"=" + dailyWeatherDtos +
                '}';
    }
}
