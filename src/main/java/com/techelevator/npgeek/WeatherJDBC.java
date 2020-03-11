package com.techelevator.npgeek;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class WeatherJDBC extends Weather implements WeatherDAO {

private JdbcTemplate jdbcTemplate;
	
	public WeatherJDBC (DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setDay(results.getInt("fivedayforecastvalue"));
		weather.setLow(results.getInt("low"));
		weather.setHigh(results.getInt("high"));
		weather.setForecast(results.getString("forecast"));
		return weather;
	}
	
	public Weather findWeatherByCode(String parkCode) {
		Weather weather = new Weather();
		String query = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(query, parkCode);
		if(result.next()) {
			weather = mapRowToWeather(result);
		}
		return weather;
	}

	public void createWeather(Weather weather) {
		// TODO Auto-generated method stub
		
	}

	public void updateWeather(Weather weather) {
		// TODO Auto-generated method stub
		
	}

	public void deleteWeather(Weather weather) {
		// TODO Auto-generated method stub
		
	}

}
