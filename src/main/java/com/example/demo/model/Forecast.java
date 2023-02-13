package com.example.demo.model;

import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Forecast {
    public ArrayList<Forecastday> forecastday;
}
