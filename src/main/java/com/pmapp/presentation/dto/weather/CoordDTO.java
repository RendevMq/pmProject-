package com.pmapp.presentation.dto.weather;

import lombok.Data;

import java.io.Serializable;

@Data
public class CoordDTO implements Serializable {
    private double lon;
    private double lat;
}