package com.berserk.open_api_projects.weather_app.entity.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Weather(
        @JsonProperty("id") String id,
        @JsonProperty("main") String main,
        @JsonProperty("description") String description,
        @JsonProperty("icon") String icon
){ }
