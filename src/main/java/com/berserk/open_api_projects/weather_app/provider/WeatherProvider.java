package com.berserk.open_api_projects.weather_app.provider;


import com.berserk.open_api_projects.weather_app.entity.CityCoordinates;
import com.berserk.open_api_projects.weather_app.entity.CityWeather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherProvider {
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.url}")
    private String weatherUrl;

    public CityWeather getWeather(CityCoordinates cityCoordinates) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CityWeather> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);

        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(weatherUrl)
                .queryParam("lat" , cityCoordinates.latitude())
                .queryParam("lon", cityCoordinates.longitude())
                .queryParam("appid", apiKey).build();

        try{
            responseEntity = restTemplate
                    .exchange(uriBuilder.toUriString(),
                            HttpMethod.GET,
                            requestEntity,
                            CityWeather.class
                    );
        }catch (HttpStatusCodeException e){
            throw new Exception(e.getMessage());
        }
        return responseEntity.getBody();
    }

}
