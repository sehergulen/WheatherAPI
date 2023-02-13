package com.example.demo;

import com.example.demo.dto.mapper.DtoMapper;
import com.example.demo.dto.object.DailyWeatherDto;
import com.example.demo.dto.object.ForecastWeatherDto;
import com.example.demo.model.Forecastday;
import com.example.demo.model.Weather;
import com.example.demo.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ApiService apiService;

	@Autowired
	DtoMapper dtoMapper;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		log.info("Program started");

		// Reading data using readLine
		log.info("enter city >  ");
		String city = reader.readLine();
		if (city.equals("")) {
			log.error("Please enter a valid city name");
			System.exit(0);
		}

		try {
			Weather weather = apiService.getCurrentWeather(city);
			DailyWeatherDto dailyWeatherDto = dtoMapper.convertWeatherToDaily(weather);
			log.info("daily weather: {}", dailyWeatherDto);
		} catch (Exception e) {
			log.error("exception caught getCurrentWeather request:", e);
		}



		try {
			Weather weather = apiService.getForecastWeather(city, 7);
			ForecastWeatherDto weekly = dtoMapper.convertToWeekly(weather);
			log.info("weekly weather: {}", weekly);
		} catch (Exception e) {
			log.error("exception caught getForecastWeather weekly request:", e);

		}

		try {
			Weather weather = apiService.getForecastWeather(city, 30);
			ForecastWeatherDto monthly = dtoMapper.convertToMonthly(weather);
			log.info("monthly weather: {}", monthly);
		} catch (Exception e) {
			log.error("exception caught getForecastWeather monthly request:", e);
		}

		log.info("Finished");
	}
}
