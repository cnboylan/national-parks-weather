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



	@Override
	public boolean saveSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		int	 surveyId = getNextSurveyId();
		String insertIntoSurvey = "INSERT INTO survey_result VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertIntoSurvey, surveyId, parkCode, emailAddress, state, activityLevel);
		return true;
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
	
	public int getNextSurveyId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_surveyid')");
		if (nextIdResult.next()) {
			return nextIdResult.getInt(1);
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