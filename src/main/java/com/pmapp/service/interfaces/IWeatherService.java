package com.pmapp.service.interfaces;

import com.pmapp.presentation.dto.weather.WeatherResponseDTO;

public interface IWeatherService {
    WeatherResponseDTO getWeather(String city);
}
