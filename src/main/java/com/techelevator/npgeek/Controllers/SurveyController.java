package com.techelevator.npgeek.Controllers;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.ParkDAO;
import com.techelevator.npgeek.WeatherDAO;
import com.techelevator.npgeek.Models.Survey;
import com.techelevator.npgeek.Models.SurveyDAO;
import com.techelevator.npgeek.Models.SurveyResults;


@Controller
public class SurveyController {



	@Autowired
	private ParkDAO parkDAO;

	
	@Autowired
	private SurveyDAO surveyDAO;
		
	
		@RequestMapping("/survey") 
		public String displaySurvey(Model modelHolder, ModelMap map) {
			
			
			
			if (!modelHolder.containsAttribute("survey")) {
				modelHolder.addAttribute("survey", new Survey());
			}
			map.addAttribute("parks", parkDAO.getAllParks());
			List<String> states = getStates();
			map.addAttribute("states", states);	
			return "survey";
		}
		
		@RequestMapping(path="/survey", method=RequestMethod.POST)
		public String submitSurvey (@Valid @ModelAttribute("survey") Survey survey, 
									BindingResult result, ModelMap model, RedirectAttributes flash) {
			
			if (result.hasErrors()) {
		
				return "survey";
			}
			
			surveyDAO.saveSurvey(survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
			
//			if(surveyDAO.saveSurvey(survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel())) {
				flash.addFlashAttribute("message", survey);
			 
			
			return "redirect:/surveyResults";
		}
		
		
		
		
		@RequestMapping("/surveyResults")
		public String displaySurveyResults(SurveyResults surveyResult, BindingResult result, RedirectAttributes flash, ModelMap map) {
			List <SurveyResults> surveyResult2 = new ArrayList<SurveyResults>();
			surveyResult2 = surveyDAO.getAllSurveyResults();
		 
			if(result.hasErrors()) {
				flash.addFlashAttribute("SurveyResults", surveyResult);
				flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result); 
				return "/survey";
			}
			map.addAttribute("surveyResults", surveyResult2);
			
			
			return "surveyResults";
			
		}
		
		public List<String> getStates() {
			List<String> states = new ArrayList<String>();
			states.add("");
			states.add("AL");
			states.add("AK");
			states.add("AZ");
			states.add("AR");
			states.add("CA");
			states.add("CO");
			states.add("CT");
			states.add("DE");		
			states.add("FL");
			states.add("GA");
			states.add("HI");
			states.add("ID");
			states.add("IL");
			states.add("IN");
			states.add("IA");
			states.add("KS");				
			states.add("KY");
			states.add("LA");
			states.add("ME");
			states.add("MD");
			states.add("MA");
			states.add("MI");
			states.add("MN");
			states.add("MS");		
			states.add("MO");
			states.add("MT");
			states.add("NE");
			states.add("NV");
			states.add("NH");
			states.add("NJ");
			states.add("NM");
			states.add("NY");			
			states.add("NC");
			states.add("ND");
			states.add("OH");
			states.add("OK");
			states.add("OR");		
			states.add("PA");
			states.add("RI");
			states.add("SC");
			states.add("SD");
			states.add("TN");
			states.add("TX");
			states.add("UT");
			states.add("VT");				
			states.add("VA");
			states.add("WA");
			states.add("WV");
			states.add("WI");
			states.add("WY");
			states.add("other");
			return states;
		}

}
