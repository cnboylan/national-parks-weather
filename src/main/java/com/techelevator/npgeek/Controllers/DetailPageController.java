package com.techelevator.npgeek.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String displayParkDetail(@RequestParam String code, @RequestParam(required=false) String temp, ModelMap map, HttpSession session) {
		Park park = parkDAO.findParkByCode(code);
		map.addAttribute("park", park);
		List<Weather> weatherList = null;
		
		String value = (String) session.getAttribute("temp");
		
		if(value == null) {
			value = "1";
		} else if (!value.equals(temp) && temp != null) {
			value = temp;
		}
		
		if(value.equals("1")) {
			weatherList = weatherDAO.findWeatherByCode(code);
		} else if(value.equals("2")) {
			weatherList = weatherDAO.tempToCelsius(weatherDAO.findWeatherByCode(code));
		}
		
		map.addAttribute("forecast", weatherList);
		session.setAttribute("temp", value);
		
		return "pageDetail";
	}

}
