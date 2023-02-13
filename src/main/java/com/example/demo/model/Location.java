package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String name;
    private String country;
    private String tz_id;
    private String localtime;

}
