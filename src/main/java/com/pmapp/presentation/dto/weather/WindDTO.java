package com.pmapp.presentation.dto.weather;

import lombok.Data;

import java.io.Serializable;

@Data
public class WindDTO implements Serializable {
    private double speed;
    private int deg;
    private double gust;
}