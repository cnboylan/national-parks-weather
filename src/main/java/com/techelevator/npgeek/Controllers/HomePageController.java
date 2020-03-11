package com.techelevator.npgeek.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	
	@RequestMapping(path="/")
	public String displayHomePage() {
		return "HomePage";
	}
}
