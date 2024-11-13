package com.pmapp.presentation.dto.weather;

import lombok.Data;

import java.io.Serializable;

@Data
public class MainDTO implements Serializable {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    private int grnd_level;
}