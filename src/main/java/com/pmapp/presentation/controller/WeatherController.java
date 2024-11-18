package com.pmapp.presentation.controller;

import com.pmapp.presentation.dto.weather.CoordDTO;
import com.pmapp.presentation.dto.weather.WeatherResponseDTO;
import com.pmapp.service.interfaces.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WeatherController {

    private final IWeatherService iWeatherService;

    @Autowired
    public WeatherController(IWeatherService iWeatherService) {
        this.iWeatherService = iWeatherService;
    }

    @PostMapping("/weather")
    public WeatherResponseDTO getWeatherByCoordinates(@RequestBody CoordDTO coordDTO) {
        try {
            return iWeatherService.getWeather(coordDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving weather data", e);
        }
    }
}
//
//package com.pmapp.presentation.controller;
//
//import com.pmapp.presentation.dto.weather.WeatherResponseDTO;
//import com.pmapp.service.interfaces.IWeatherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//@RestController
//@RequestMapping("/weather")
//public class WeatherController {
//
//    private final IWeatherService iWeatherService;
//
//    @Autowired
//    public WeatherController(IWeatherService iWeatherService) {
//        this.iWeatherService = iWeatherService;
//    }
//
//    @GetMapping("/{lat}/{lon}")
//    public WeatherResponseDTO getWeatherByCoordinates(@PathVariable double lat, @PathVariable double lon) {
//        try {
//            return iWeatherService.getWeather(lat, lon);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving weather data", e);
//        }
//    }
//}

