package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class WeatherJDBC extends Weather implements WeatherDAO {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public WeatherJDBC (DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setDay(results.getInt("fivedayforecastvalue"));
		weather.setLowTemp(results.getInt("low"));
		weather.setHighTemp(results.getInt("high"));
		weather.setForecast(results.getString("forecast"));
		weather.setWeatherMessage(weather.getForecast());
		return weather;
	}
	
	public List<Weather> findWeatherByCode(String parkCode) {
		List<Weather> weatherList = new ArrayList<Weather>();
		String query = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, parkCode);
		while(results.next()) {
			Weather weather = mapRowToWeather(results);
			weatherList.add(weather);
		}
		return weatherList;
	}
	
	public List<Weather> tempToCelsius(List<Weather> weatherList) {
		for(Weather weather : weatherList) {
			double high = (((weather.getHighTemp() - 32) * 5) / 9);
			double low = (((weather.getLowTemp() - 32) * 5) / 9);
			weather.setHighTemp((int)high);
			weather.setLowTemp((int)low);
		}
		return weatherList;
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
