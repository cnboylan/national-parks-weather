package com.techelevator.npgeek;

public class Weather {
	
	private String parkCode;
	private int day;
	private int lowTemp;
	private int highTemp;
	private String forecast;
	private String weatherMessage;
	
	public Weather() {
		
	}
	
	public String getParkCode() {
		return parkCode;
	}
	
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getLowTemp() {
		return lowTemp;
	}
	
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	
	public int getHighTemp() {
		return highTemp;
	}
	
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	
	public String getForecast() {
		return forecast;
	}
	
	public void setForecast(String forecast) {
			this.forecast = forecast.replaceAll("\\s+", "");
	}
	
	public void setWeatherMessage(String forecast) {
		
		if(forecast.equals("snow")){
			if(highTemp < 20 || lowTemp < 20){
				this.weatherMessage = "Pack snowshoes and beware exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				this.weatherMessage = "Pack snowshoes and wear breathable layers.";
			}else if( (highTemp - lowTemp > 20)&& highTemp > 75){
				this.weatherMessage = "Pack snowshoes,wear breathable layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				this.weatherMessage = "Pack snowshoes and bring an extra gallon of water.";
			} else {
				this.weatherMessage = "Pack snowshoes";
			}
		} else if (forecast.equals("rain")){
			if(highTemp < 20 || lowTemp < 20){
				this.weatherMessage = "Pack rain gear and waterproof shoes. Beware of exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				this.weatherMessage = "Pack rain gear and waterproof shoes. Wear breathable layers.";
			}else if( (highTemp - lowTemp > 20) && highTemp > 75){
				this.weatherMessage = "Pack rain gear,waterproof shoes, wear breathable layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				this.weatherMessage = "Pack rain gear,waterproof shoes and bring an extra gallon of water.";
			}else {
				this.weatherMessage = "Pack rain gear and waterproof shoes.";
			}
		}else if (forecast.equals("thunderstorms")){
			if(highTemp < 20 || lowTemp < 20){
				this.weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Beware of exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				this.weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Wear breathable layers.";
			}else if( (highTemp - lowTemp > 20) && highTemp > 75){
				this.weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Wear breathble layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				this.weatherMessage = "Seek shelter and avoid hiking on exposed ridges. Bring an extra gallon of water.";
			}else {
				this.weatherMessage = "Seek shelter and avoid hiking on exposed ridges";
			}	
		}else if (forecast.equals("sunny")){
			if(highTemp < 20 || lowTemp < 20){
				this.weatherMessage = "Pack sunblock. Beware of exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				this.weatherMessage = "Pack sunblock. Wear breathable layers.";
			}else if( (highTemp - lowTemp > 20)&& highTemp > 75){
				this.weatherMessage = "Pack sunblock, wear breathable layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				this.weatherMessage = "Pack sunblock and bring an extra gallon of water.";
			}else {
				this.weatherMessage = "Pack sunblock";
			}	
		} else {
			if(highTemp < 20 || lowTemp < 20){
				this.weatherMessage = "Beware of exposure to frigid temperatures.";
			}else if( highTemp - lowTemp > 20){
				this.weatherMessage = "Wear breathable layers.";
			}else if( (highTemp - lowTemp > 20)&& highTemp > 75){
				this.weatherMessage = "Wear breathable layers and bring an extra gallon of water.";
			}else if(highTemp > 75){
				this.weatherMessage = "Bring an extra gallon of water.";
			}
		}
	}
	
	public String getWeatherMessage() {
		return weatherMessage;
	}
}
