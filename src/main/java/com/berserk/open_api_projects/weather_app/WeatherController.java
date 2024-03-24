package com.berserk.open_api_projects.weather_app;


import com.berserk.open_api_projects.weather_app.entity.CityWeather;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public @ResponseBody CityWeather weather(@PathVariable("city") String city) throws Exception {
        return weatherService.getWeather(city);
    }

}
