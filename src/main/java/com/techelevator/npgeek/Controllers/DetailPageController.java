package com.techelevator.npgeek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.WeatherDAO;

@Controller
public class DetailPageController {
	
	@Autowired
	private ParkDAO parkDAO;
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	@RequestMapping (path = "/detail")
	public String displayParkDetail(@RequestParam String code, ModelMap map) {
		Park park = parkDAO.findParkByCode(code);
		map.addAttribute("park", park);
		Weather weather = weatherDAO.findWeatherByCode(code);
		map.addAttribute("weather", weather);
		
		return "pageDetail";
	}

}
