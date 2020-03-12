package com.techelevator.npgeek.Models;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component
public class JDBCSurveyDao implements SurveyDAO{

	

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
}
//	@Override
//	public String getParkCodebyName(String parkName) {
//		String sqlGetParkCode = "SELECT parkcode " + "FROM Park " + "WHERE parkname = ? ";
//		
//		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetParkCode, parkName);
//		return 
//	}
	
//	@Override
//	public Survey createSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
//		
//		
//		String sqlNewSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel)"
//				+ " VALUES(?, ?, ?, ?, ?)";
//		
//		Survey newSurvey = new Survey(surveyId, parkCode, emailAddress, state, activityLevel);
//		newSurvey.setSurveyId(getNextSurveyId());
//		newSurvey.setParkCode(parkCode);
//		newSurvey.setEmailAddress(emailAddress);;
//		newSurvey.setState(state);
//		newSurvey.setActivityLevel(activityLevel);
//		 
//		
//		
//	
//		jdbcTemplate.update(sqlNewSurvey, 
//				newSurvey.getSurveyId(), 
//				newSurvey.getParkCode(), 
//				newSurvey.getEmailAddress(), 
//				newSurvey.getState(), 
//				newSurvey.getActivityLevel());
//				
//		
//		return newSurvey;
//}
	
	

//	private int getNextSurveyId() {
//		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_surveyid')");
//		if(nextIdResult.next()) {
//			return nextIdResult.getInt(1);
//		}else {
//			throw new RuntimeException("Something went wrong while getting an id for the new survey");
//		}
//	}
//}


	@Override
	public void saveSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		long	 surveyId = getNextSurveyId();
		String insertIntoSurvey = "INSERT INTO survey_result VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertIntoSurvey, surveyId, parkCode, emailAddress, state, activityLevel);
	}

	@Override
	public List<SurveyResults> getAllSurveyResults() {
		List<SurveyResults> surveyResultList = new ArrayList<SurveyResults>();
		String getAllSurveyResults = "SELECT survey_result.parkcode, parkname, "
				+ " count(survey_result.parkcode) AS surveycount FROM survey_result "
				+ " JOIN park ON park.parkcode = survey_result.parkcode " 
				+ " GROUP BY survey_result.parkcode, parkname ORDER BY surveycount DESC, parkname ASC";
		SurveyResults theSurveyResult = new SurveyResults();
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllSurveyResults);
		while (results.next()) {
			theSurveyResult = mapRowToSurveyResult(results);
			surveyResultList.add(theSurveyResult);
			
		}
		return surveyResultList;
	}
	
	public long getNextSurveyId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_surveyid')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		}
		else {
			throw new RuntimeException("Something went wrong with survey sequence");
		}
	}
	
	private SurveyResults mapRowToSurveyResult(SqlRowSet results) {
		SurveyResults theSurveyResult = new SurveyResults();
		theSurveyResult.setParkCode(results.getString("parkcode"));
		theSurveyResult.setParkName(results.getString("parkname"));
		theSurveyResult.setSurveySum(results.getInt("surveycount"));
		return theSurveyResult;
	}
	
	

}