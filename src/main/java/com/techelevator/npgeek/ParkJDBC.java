package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class ParkJDBC extends Park implements ParkDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ParkJDBC (DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private Park mapRowToPark(SqlRowSet results) {
		Park park = new Park();
		park.setParkCode(results.getString("parkcode"));
		park.setParkName(results.getString("parkname"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFt(results.getInt("elevationinfeet"));
		park.setMilesOfTrail(results.getFloat("milesoftrail"));
		park.setNumOfCampsites(results.getInt("numberofcampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setAnnualVisitors(results.getInt("annualvisitorcount"));
		park.setQuote(results.getString("inspirationalquote"));
		park.setQuoteSource(results.getString("inspirationalquotesource"));
		park.setDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getInt("entryfee"));
		park.setNumAnimalSpecies(results.getInt("numberofanimalspecies"));
		return park;
	}
	
	public List<Park> getAllParks() {
		List<Park> parkList = new ArrayList<Park>();
		String query = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(query);
		while(results.next()) {
			Park park = mapRowToPark(results);
			parkList.add(park);
		}
		return parkList;
	}

	public Park findParkByCode(String parkCode) {
		Park park = new Park();
		String query = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(query, parkCode);
		if(result.next()) {
			park = mapRowToPark(result);
		}
		return park;
	}
	
	public List<String> getAllParkNames() {
		List<String> parkNames = new ArrayList<String>();
		String query = "SELECT parkname FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(query);
		while(results.next()) {
			String name = results.getString("parkname");
			parkNames.add(name);
		}
		return parkNames;
	}

	public void createPark(Park park) {
		// TODO Auto-generated method stub
		
	}

	public void updatePark(Park park) {
		// TODO Auto-generated method stub
		
	}

	public void deletePark(Park park) {
		// TODO Auto-generated method stub
		
	}

}
