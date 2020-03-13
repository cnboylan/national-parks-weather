package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Weather;



public class WeatherTest {

	private Weather weather;
	
	@Before
	public void setup() {
		weather = new Weather();
		
		weather.setParkCode("FMNP");
		weather.setDay(4);
		weather.setLowTemp(76);
		weather.setHighTemp(85);
		weather.setForecast("sunny");
		weather.setWeatherMessage("Pack sunblock and bring an extra gallon of water.");
	}
	
	@Test
	public void park_code_works() {
		//Act
		weather.getParkCode();
		//Assert
		Assert.assertEquals("FMNP", weather.getParkCode());
	}
	
	@Test
	public void day_works() {
		//Act
		weather.getDay();
		//Assert
		Assert.assertEquals(4, weather.getDay());
	}
	
	@Test
	public void low_temp_works() {
		//Act
		weather.getLowTemp();
		//Assert
		Assert.assertEquals(76, weather.getLowTemp());
	}
	
	@Test
	public void hight_temp_works() {
		//Act
		weather.getHighTemp();
		//Assert
		Assert.assertEquals(85, weather.getHighTemp());
	}
	
	@Test
	public void forecast_works() {
		//Act
		weather.getForecast();
		//Assert
		Assert.assertEquals("sunny", weather.getForecast());
	}
	
	@Test
	public void weather_message_works() {
		//Act
		weather.getWeatherMessage();
		//Assert
		Assert.assertEquals("Pack sunblock and bring an extra gallon of water.", weather.getWeatherMessage());
	}
	
	
	
	
	
	
	
}
