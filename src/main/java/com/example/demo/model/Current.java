package com.example.demo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Current {

    private int temp_c;
    private int wind_kph;
    private int humidity;
    private int cloud;
    Condition condition;



}
