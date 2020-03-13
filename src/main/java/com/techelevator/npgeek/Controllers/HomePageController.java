package com.techelevator.npgeek.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;

@Controller
public class HomePageController {

	@Autowired
	ParkDAO parkDAO;
	@RequestMapping(path="/")
	public String displayHomePage(ModelMap mm) {
		List<Park> allParks = parkDAO.getAllParks();
		mm.addAttribute("parks", allParks);
		return "HomePage";
	}
	
	
	
	
	@RequestMapping(path="/pageDetail")
	public String displayDetailPage() {
		
		
		
		return "DetailPage";

	}
}
