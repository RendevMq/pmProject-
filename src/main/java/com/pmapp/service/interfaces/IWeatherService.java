package com.pmapp.service.interfaces;


import com.pmapp.presentation.dto.weather.CoordDTO;
import com.pmapp.presentation.dto.weather.WeatherResponseDTO;

public interface IWeatherService {
    WeatherResponseDTO getWeather(CoordDTO coordDTO);
}

//public interface IWeatherService {
//    WeatherResponseDTO getWeather(double lat, double lon);
//}


