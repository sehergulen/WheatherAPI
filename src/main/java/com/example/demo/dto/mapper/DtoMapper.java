package com.example.demo.dto.mapper;

import com.example.demo.dto.object.DailyWeatherDto;
import com.example.demo.dto.object.ForecastWeatherDto;
import com.example.demo.model.Forecastday;
import com.example.demo.model.Location;
import com.example.demo.model.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Component
@Slf4j
public class DtoMapper {

    public DailyWeatherDto convertWeatherToDaily(Weather weather) {
        DailyWeatherDto dailyWeatherDto = new DailyWeatherDto();
        dailyWeatherDto.setCity(weather.getLocation().getName());
        dailyWeatherDto.setCountry(weather.getLocation().getCountry());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = weather.getLocation().getLocaltime().split(" ")[0];
        LocalDate localDate = LocalDate.parse(date, formatter);
        dailyWeatherDto.setDate(localDate.toString());
        dailyWeatherDto.setDay(localDate.getDayOfWeek().name());
        dailyWeatherDto.setWeather(weather.getCurrent().getTemp_c());
        dailyWeatherDto.setCondition(weather.getCurrent().getCondition().getText());
        return dailyWeatherDto;
    }

    public DailyWeatherDto convertToDaily(Forecastday forecastday, Location location) {
        DailyWeatherDto dailyWeatherDto = new DailyWeatherDto();
        dailyWeatherDto.setCity(location.getName());
        dailyWeatherDto.setCountry(location.getCountry());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = forecastday.getDate();
        LocalDate localDate = LocalDate.parse(date, formatter);
        dailyWeatherDto.setDate(localDate.toString());
        dailyWeatherDto.setDay(localDate.getDayOfWeek().name());
        dailyWeatherDto.setWeather((int) forecastday.getDay().getAvgtemp_c());
        dailyWeatherDto.setCondition(forecastday.getDay().getCondition().getText());
        return dailyWeatherDto;
    }


    public ForecastWeatherDto convertToWeekly(Weather weather) {
        ForecastWeatherDto forecastWeatherDto = new ForecastWeatherDto();
        forecastWeatherDto.setDailyWeatherDtos(new ArrayList<>());
        forecastWeatherDto.setForecastType("weekly");
        for (Forecastday forecastday : weather.getForecast().getForecastday()) {
            DailyWeatherDto dailyWeatherDto = convertToDaily(forecastday, weather.getLocation());
            forecastWeatherDto.getDailyWeatherDtos().add(dailyWeatherDto);
        }
        return forecastWeatherDto;
    }

    public ForecastWeatherDto convertToMonthly(Weather weather) {
        ForecastWeatherDto forecastWeatherDto = new ForecastWeatherDto();
        forecastWeatherDto.setDailyWeatherDtos(new ArrayList<>());
        forecastWeatherDto.setForecastType("monthly");
        for (Forecastday forecastday : weather.getForecast().getForecastday()) {
            DailyWeatherDto dailyWeatherDto = convertToDaily(forecastday, weather.getLocation());
            forecastWeatherDto.getDailyWeatherDtos().add(dailyWeatherDto);
        }
        return forecastWeatherDto;
    }
}
