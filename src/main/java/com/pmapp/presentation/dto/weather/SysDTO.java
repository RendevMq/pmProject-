package com.pmapp.presentation.dto.weather;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysDTO implements Serializable {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
}