package com.berserk.open_api_projects.weather_app.entity;


import com.berserk.open_api_projects.weather_app.entity.weather.Main;
import com.berserk.open_api_projects.weather_app.entity.weather.Weather;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CityWeather(
        String city,
        @JsonProperty("weather") Weather[] weather,
        @JsonProperty("main") Main main
        ) {

}
