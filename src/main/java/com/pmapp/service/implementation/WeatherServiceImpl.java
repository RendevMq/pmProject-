package com.pmapp.service.implementation;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmapp.presentation.dto.weather.WeatherResponseDTO;
import com.pmapp.service.http.WeatherClient;
import com.pmapp.service.interfaces.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements IWeatherService {
    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private WeatherMapper weatherMapper;

    @Override
    @Cacheable(value = "weathers", key = "#city")
    public WeatherResponseDTO getWeather(String lat , String lon) {
        String response = weatherClient.getWeatherFromApi(lat,lon);

        // Parsear la respuesta de la API
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode weatherNode = objectMapper.readTree(response);
            return weatherMapper.mapToWeatherDTO(weatherNode);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
