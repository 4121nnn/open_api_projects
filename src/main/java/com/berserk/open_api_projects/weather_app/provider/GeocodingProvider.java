package com.berserk.open_api_projects.weather_app.provider;


import com.berserk.open_api_projects.weather_app.entity.CityCoordinates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Service
public class GeocodingProvider {
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${geocoding.url}")
    private String geocodingUrl;

    public CityCoordinates getCoordinates(String city) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CityCoordinates[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);

        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("q" , city)
                .queryParam("limit", "1")
                .queryParam("appid", apiKey).build();

        try{
            responseEntity = restTemplate
                    .exchange(uriBuilder.toUriString(),
                            HttpMethod.GET,
                            requestEntity,
                            CityCoordinates[].class
                    );
        }catch (HttpStatusCodeException e){
            throw new Exception(e.getMessage());
        }
        return Objects.requireNonNull(responseEntity.getBody())[0];
    }
}
