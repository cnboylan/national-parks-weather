package com.techelevator.npgeek.Models;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Survey {

		private int surveyId;
		private String parkCode;
		
		@NotBlank(message="Email is Required")
		@Email(message="Email must be a valid email address")
		private String emailAddress;
		
		
		private String state;
		
		
		private String activityLevel;
		

		private String parkName;
		
//		private boolean emailExist;
//		private SurveyDAO dao = new JDBCSurveyDao();
//		private JdbcTemplate jdbcTemplate;
		
		public Survey() {
			
			
		}
//		@AssertTrue(message="You have already voted!")
//		public boolean isEmailExist() {
//			
//			String lookForEmail = "SELECT emailAddress FROM survey_result WHERE emailAddress = ? LIMIT 1";
//					jdbcTemplate.update(lookForEmail, emailAddress); 
//					
//					
//				
//					SqlRowSet results = jdbcTemplate.queryForRowSet(lookForEmail);
//			
//			
//			if(results != null) {
//				return true;
//			} else {
//				return false;
//			}
//			
//		}
		
		
		
		
		public Survey(int surveyId, String parkCode, String emailAddress, String state, String activityLevel) {
			this.surveyId = surveyId;
			this.parkCode = parkCode;
			this.emailAddress = emailAddress;
			this.state = state;
			this.activityLevel = activityLevel;
		}
		
		public int getSurveyId() {
			return surveyId;
		}
		public void setSurveyId(int surveyId) {
			this.surveyId = surveyId;
		}
		public String getEmailAddress() {
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getActivityLevel() {
			return activityLevel;
		}
		public void setActivityLevel(String activityLevel) {
			this.activityLevel = activityLevel;
		}



		public String getParkCode() {
			return parkCode;
		}



		public void setParkCode(String parkCode) {
			this.parkCode = parkCode;
		}


		public String getParkName() {
			return parkName;
		}


		public void setParkName(String parkName) {
			this.parkName = parkName;
		}
		
		
//		public void setEmailExist(boolean emailExist) {
//			this.emailExist = emailExist;
//		}


	
		
		
		
}
