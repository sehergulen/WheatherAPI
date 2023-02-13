package com.example.demo.model;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    Location location;
    Current current;
    Forecast forecast;

}
