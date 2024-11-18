package com.pmapp.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.pmapp.presentation.dto.weather.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherMapper {

    public WeatherResponseDTO mapToWeatherResponseDTO(JsonNode weatherNode) {
        WeatherResponseDTO weatherResponseDTO = new WeatherResponseDTO();

        // Mapeo de valores simples con valores por defecto
        weatherResponseDTO.setBase(weatherNode.has("base") ? weatherNode.get("base").asText() : "N/A");
        weatherResponseDTO.setVisibility(weatherNode.has("visibility") ? weatherNode.get("visibility").asInt() : 0);
        weatherResponseDTO.setDt(weatherNode.has("dt") ? weatherNode.get("dt").asLong() : 0L);
        weatherResponseDTO.setTimezone(weatherNode.has("timezone") ? weatherNode.get("timezone").asInt() : 0);
        weatherResponseDTO.setId(weatherNode.has("id") ? weatherNode.get("id").asInt() : 0);
        weatherResponseDTO.setName(weatherNode.has("name") ? weatherNode.get("name").asText() : "Unknown");
        weatherResponseDTO.setCod(weatherNode.has("cod") ? weatherNode.get("cod").asInt() : 0);

// Mapea la parte de coord
        JsonNode coordNode = weatherNode.get("coord");
        if (coordNode != null) {
            CoordDTO coordDTO = new CoordDTO();
            coordDTO.setLon(coordNode.has("lon") ? coordNode.get("lon").asDouble() : 0.0);
            coordDTO.setLat(coordNode.has("lat") ? coordNode.get("lat").asDouble() : 0.0);
            weatherResponseDTO.setCoord(coordDTO);
        }


        // Mapea la lista de weather con valores por defecto
        JsonNode weatherArray = weatherNode.get("weather");
        if (weatherArray != null && weatherArray.isArray()) {
            List<WeatherDTO> weatherList = new ArrayList<>();
            for (JsonNode weatherElement : weatherArray) {
                WeatherDTO weatherDTO = new WeatherDTO();
                weatherDTO.setId(weatherElement.has("id") ? weatherElement.get("id").asInt() : 0);
                weatherDTO.setMain(weatherElement.has("main") ? weatherElement.get("main").asText() : "Unknown");
                weatherDTO.setDescription(weatherElement.has("description") ? weatherElement.get("description").asText() : "No description");
                weatherDTO.setIcon(weatherElement.has("icon") ? weatherElement.get("icon").asText() : "N/A");
                weatherList.add(weatherDTO);
            }
            weatherResponseDTO.setWeather(weatherList);
        }

        // Mapea la parte de main con valores por defecto
        JsonNode mainNode = weatherNode.get("main");
        if (mainNode != null) {
            MainDTO mainDTO = new MainDTO();
            mainDTO.setTemp(mainNode.has("temp") ? mainNode.get("temp").asDouble() : 0.0);
            mainDTO.setFeels_like(mainNode.has("feels_like") ? mainNode.get("feels_like").asDouble() : 0.0);
            mainDTO.setTemp_min(mainNode.has("temp_min") ? mainNode.get("temp_min").asDouble() : 0.0);
            mainDTO.setTemp_max(mainNode.has("temp_max") ? mainNode.get("temp_max").asDouble() : 0.0);
            mainDTO.setPressure(mainNode.has("pressure") ? mainNode.get("pressure").asInt() : 0);
            mainDTO.setHumidity(mainNode.has("humidity") ? mainNode.get("humidity").asInt() : 0);
            mainDTO.setSea_level(mainNode.has("sea_level") ? mainNode.get("sea_level").asInt() : 0);
            mainDTO.setGrnd_level(mainNode.has("grnd_level") ? mainNode.get("grnd_level").asInt() : 0);
            weatherResponseDTO.setMain(mainDTO);
        }

        // Mapea la parte de wind con valores por defecto
        JsonNode windNode = weatherNode.get("wind");
        if (windNode != null) {
            WindDTO windDTO = new WindDTO();
            windDTO.setSpeed(windNode.has("speed") ? windNode.get("speed").asDouble() : 0.0);
            windDTO.setDeg(windNode.has("deg") ? windNode.get("deg").asInt() : 0);
            windDTO.setGust(windNode.has("gust") ? windNode.get("gust").asDouble() : 0.0);
            weatherResponseDTO.setWind(windDTO);
        }

        // Mapea la parte de clouds con valores por defecto
        JsonNode cloudsNode = weatherNode.get("clouds");
        if (cloudsNode != null) {
            CloudsDTO cloudsDTO = new CloudsDTO();
            cloudsDTO.setAll(cloudsNode.has("all") ? cloudsNode.get("all").asInt() : 0);
            weatherResponseDTO.setClouds(cloudsDTO);
        }

        // Mapea la parte de sys con valores por defecto
        JsonNode sysNode = weatherNode.get("sys");
        if (sysNode != null) {
            SysDTO sysDTO = new SysDTO();
            sysDTO.setType(sysNode.has("type") ? sysNode.get("type").asInt() : 0);
            sysDTO.setId(sysNode.has("id") ? sysNode.get("id").asInt() : 0);
            sysDTO.setCountry(sysNode.has("country") ? sysNode.get("country").asText() : "N/A");
            sysDTO.setSunrise(sysNode.has("sunrise") ? sysNode.get("sunrise").asLong() : 0L);
            sysDTO.setSunset(sysNode.has("sunset") ? sysNode.get("sunset").asLong() : 0L);
            weatherResponseDTO.setSys(sysDTO);
        }

        return weatherResponseDTO;
    }
}
