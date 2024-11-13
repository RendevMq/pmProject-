package com.pmapp.service.http;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private static final String BASE_LEFT_URL = "https://api.openweathermap.org/data/2.5/weather?lat=";
    private static final String BASE_CENTER_URL = "&lon=";
    private static final String BASE_RIGHT_URL = "&appid=";

    @Value("${security.api.key.private}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public String getWeatherFromApi(String lat , String lon) {
        String url = BASE_LEFT_URL + lat + BASE_CENTER_URL + lon + BASE_RIGHT_URL + apiKey;
        return restTemplate.getForObject(url, String.class);
    }
}
