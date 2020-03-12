package com.techelevator.npgeek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.ParkDAO;

@Controller
public class HomePageController {

	//@Autowired
	//ParkDAO parkDAO;
	@RequestMapping(path="/")
	public String displayHomePage(ModelMap mm) {
		//mm.put("parks", parkDAO.getAllParks());
		
		return "HomePage";
	}
	
	
	
	
	@RequestMapping(path="/DetailPage")
	public String displayDetailPage() {
		return "DetailPage";

	}
}
