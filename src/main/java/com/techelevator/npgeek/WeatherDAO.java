package com.techelevator.npgeek;

import java.util.List;

public interface WeatherDAO {
	
	public List<Weather> findWeatherByCode(String parkCode);
	public List<Weather> tempToCelsius(List<Weather> weatherList);
	public void createWeather(Weather weather);
	public void updateWeather(Weather weather);
	public void deleteWeather(Weather weather);

}
