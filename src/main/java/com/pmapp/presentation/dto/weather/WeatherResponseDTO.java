package com.pmapp.presentation.dto.weather;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeatherResponseDTO implements Serializable {
    private CoordDTO coord;
    private List<WeatherDTO> weather;
    private String base;
    private MainDTO main;
    private int visibility;
    private WindDTO wind;
    private CloudsDTO clouds;
    private long dt;
    private SysDTO sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
}
