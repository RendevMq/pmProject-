package com.pmapp.presentation.dto.weather;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherDTO implements Serializable {
    private int id;
    private String main;
    private String description;
    private String icon;
}