package com.berserk.open_api_projects.weather_app.entity.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Main(
        @JsonProperty("temp") Double temp,
        @JsonProperty("feels_like") Double feelsLike,
        @JsonProperty("pressure") Integer pressure,
        @JsonProperty("humidity") Integer humidity
) { }
