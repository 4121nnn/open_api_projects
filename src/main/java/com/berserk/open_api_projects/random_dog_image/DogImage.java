package com.berserk.open_api_projects.random_dog_image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DogImage(@JsonProperty("message") String message) {
}
