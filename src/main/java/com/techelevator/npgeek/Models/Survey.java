package com.techelevator.npgeek.Models;

public class Survey {

		private int surveyId;
		private String parkCode;
		private String emailAddress;
		private String state;
		private String activityLevel;
		private String parkName;
		private String surveySum;
		
		
		public Survey() {
			
			
		}
		
		
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


		public String getSurveySum() {
			return surveySum;
		}


		public void setSurveySum(String surveySum) {
			this.surveySum = surveySum;
		}
		
		
		
}
