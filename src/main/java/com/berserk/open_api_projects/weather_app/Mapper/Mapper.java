package com.berserk.open_api_projects.weather_app.Mapper;

import com.berserk.open_api_projects.weather_app.entity.weather.Main;

public class Mapper {
    public static Main toCelsius(Main main){
        return new Main(
                convertToCelsius(main.temp()),
                convertToCelsius(main.feelsLike()),
                main.pressure(),
                main.humidity()
        );
    }
    public static double convertToCelsius(Double kelvin){
        return  Math.round((kelvin - 273.15) * 10.0) / 10.0;
    }
}
