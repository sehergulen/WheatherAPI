package com.example.demo.dto.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DailyWeatherDto {
    private String city;
    private String country;
    private String date;
    private String day;
    private int weather;
    private String condition;

    @Override
    public String toString() {
        return "{" +
                "city=" + city  +
                ", country=" + country +
                ", date=" + date +
                ", day=" + day +
                ", weather=" + weather +  "°C"+
                ", condition=" + condition+
                "}\n";
    }
}
