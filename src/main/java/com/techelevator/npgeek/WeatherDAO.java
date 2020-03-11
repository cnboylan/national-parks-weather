package com.techelevator.npgeek;

public interface WeatherDAO {
	
	public Weather findWeatherByCode(String parkCode);
	public void createWeather(Weather weather);
	public void updateWeather(Weather weather);
	public void deleteWeather(Weather weather);

}
