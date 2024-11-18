package com.pmapp.service.http;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherClient {

    private static final String BASE_LEFT_URL = "https://api.openweathermap.org/data/2.5/weather?lat=";
    private static final String BASE_CENTER_URL = "&lon=";
    private static final String BASE_RIGHT_URL = "&appid=";

    @Value("${security.api.key.private}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

//    public String getWeatherFromApi(String lat , String lon) {
////        System.out.println(lat);
////        System.out.println(lon);
//////        String url = BASE_LEFT_URL + lat + BASE_CENTER_URL + lon + BASE_RIGHT_URL + apiKey;
//////        String url = "https://api.openweathermap.org/data/2.5/weather?lat=-12.09057&lon=-77.02274&appid=ae71b332f986ef7b7657459967d8c9c7";
////          String url = "https://api.openweathermap.org/data/2.5/weather?lat=-12.09057&lon=10.99&appid=ae71b332f986ef7b7657459967d8c9c7";
////        System.out.println(url);
////        return restTemplate.getForObject(url, String.class);
//
//        String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather")
//                .queryParam("lat", lat)
//                .queryParam("lon", lon)
//                .queryParam("appid", apiKey)
//                .toUriString();
//        System.out.println("Request URL: " + url);
//        System.out.println(url);
//        return restTemplate.getForObject(url, String.class);
//    }

    public String getWeatherFromApi(double lat, double lon) {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather")
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", apiKey)
                .toUriString();

        System.out.println("Request URL: " + url);
        return restTemplate.getForObject(url, String.class);
    }

//    public String getWeatherFromApi(String lat, String lon) {
//        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
//
//        System.out.println("Request URL: " + url);
//
//        HttpEntity<String> entity = new HttpEntity<>(null);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//
//        System.out.println("Response Status Code: " + response.getStatusCode());
//        System.out.println("Response Body: " + response.getBody());
//
//        return response.getBody();
//    }

}

//package com.pmapp.service.http;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Component
//public class WeatherClient {
//
//    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
//
//    @Value("${security.api.key.private}")
//    private String apiKey;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public String getWeatherFromApi(double lat, double lon) {
//        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
//                .queryParam("lat", lat)
//                .queryParam("lon", lon)
//                .queryParam("appid", apiKey)
//                .toUriString();
//
//        System.out.println("Request URL: " + url);
//        return restTemplate.getForObject(url, String.class);
//    }
//}
//
