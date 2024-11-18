package com.pmapp.service.implementation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmapp.presentation.dto.weather.CoordDTO;
import com.pmapp.presentation.dto.weather.WeatherResponseDTO;
import com.pmapp.service.http.WeatherClient;
import com.pmapp.service.interfaces.IWeatherService;
import com.pmapp.util.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements IWeatherService {

    private final WeatherClient weatherClient;
    private final WeatherMapper weatherMapper;

    @Autowired
    public WeatherServiceImpl(WeatherClient weatherClient, WeatherMapper weatherMapper) {
        this.weatherClient = weatherClient;
        this.weatherMapper = weatherMapper;
    }

    @Override
    public WeatherResponseDTO getWeather(CoordDTO coordDTO) {
        String response = weatherClient.getWeatherFromApi(coordDTO.getLat(), coordDTO.getLon());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode weatherNode = objectMapper.readTree(response);
            return weatherMapper.mapToWeatherResponseDTO(weatherNode);
        } catch (IOException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            throw new RuntimeException("Error parsing weather data", e);
        }
    }


}

//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pmapp.presentation.dto.weather.WeatherResponseDTO;
//import com.pmapp.service.http.WeatherClient;
//import com.pmapp.service.interfaces.IWeatherService;
//import com.pmapp.util.WeatherMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//public class WeatherServiceImpl implements IWeatherService {
//
//    private final WeatherClient weatherClient;
//    private final WeatherMapper weatherMapper;
//
//    @Autowired
//    public WeatherServiceImpl(WeatherClient weatherClient, WeatherMapper weatherMapper) {
//        this.weatherClient = weatherClient;
//        this.weatherMapper = weatherMapper;
//    }
//
//    @Override
//    public WeatherResponseDTO getWeather(double lat, double lon) {
//        String response = weatherClient.getWeatherFromApi(lat, lon);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            JsonNode weatherNode = objectMapper.readTree(response);
//            return weatherMapper.mapToWeatherResponseDTO(weatherNode);
//        } catch (IOException e) {
//            throw new RuntimeException("Error parsing weather data", e);
//        }
//    }
//}

