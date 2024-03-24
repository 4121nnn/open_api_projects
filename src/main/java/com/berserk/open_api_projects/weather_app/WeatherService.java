package com.berserk.open_api_projects.weather_app;

import com.berserk.open_api_projects.weather_app.Mapper.Mapper;
import com.berserk.open_api_projects.weather_app.entity.CityCoordinates;
import com.berserk.open_api_projects.weather_app.entity.CityWeather;
import com.berserk.open_api_projects.weather_app.provider.GeocodingProvider;
import com.berserk.open_api_projects.weather_app.provider.WeatherProvider;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeocodingProvider geocodingProvider;
    private WeatherProvider weatherProvider;

    public WeatherService(GeocodingProvider geocodingProvider, WeatherProvider weatherProvider){
        this.geocodingProvider = geocodingProvider;
        this.weatherProvider = weatherProvider;
    }

    public CityWeather getWeather(String city) throws Exception {
        CityCoordinates cityCoordinates = geocodingProvider.getCoordinates(city);

        CityWeather cityWeather = weatherProvider.getWeather(cityCoordinates);
        return new CityWeather(
                city.toUpperCase(),
                cityWeather.weather(),
                Mapper.toCelsius(cityWeather.main())
        );

    }
}
