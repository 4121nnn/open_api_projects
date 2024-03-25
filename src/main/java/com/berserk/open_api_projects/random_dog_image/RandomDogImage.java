package com.berserk.open_api_projects.random_dog_image;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/random-dog-image")
public class RandomDogImage {
    private final String randomDogImageUrl = "https://dog.ceo/api/breeds/image/random";
    @GetMapping
    public String getRandomDogImage(){
        return randomDogImageService();
    }

    public String randomDogImageService(){
        RestTemplate restTemplate = new RestTemplate();
        DogImage dogImage =  restTemplate.getForObject(randomDogImageUrl, DogImage.class);
        assert dogImage != null;
        return dogImage.message();
    }
}
