package com.techelevator.npgeek;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


import com.techelevator.npgeek.Models.JDBCSurveyDao;
import com.techelevator.npgeek.Models.Survey;
import com.techelevator.npgeek.Models.SurveyDAO;
import com.techelevator.npgeek.Models.SurveyResults;



public class JDBCSurveyDAOTest {

	private static SingleConnectionDataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SurveyDAO dao;
	private Survey mySurvey;
	private SurveyResults myResults;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dataSource.destroy();
	}

	@Before
	public void setUp() throws Exception {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		dao = new JDBCSurveyDao();
		mySurvey = new Survey();	
	}
	

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_and_set_surveyId() {
		int surveyId = 12;
		mySurvey.setSurveyId(surveyId);
		assertEquals(12, mySurvey.getSurveyId());
	}
	
	@Test
	public void test_get_set_parkcode() {
		String parkCode = "GNTF";
		mySurvey.setParkCode(parkCode);
		assertEquals("GNTF", mySurvey.getParkCode());
	}
	@Test
	public void test_get_set_email() {
		String emailAddress = "hiker5@yahoo.com";
		mySurvey.setEmailAddress(emailAddress);
		assertEquals("hiker5@yahoo.com", mySurvey.getEmailAddress());
	}
	
	@Test
	public void test_get_set_state() {
		String state = "Florida";
		mySurvey.setState(state);
		assertEquals("Florida", mySurvey.getState());
	}
	
	@Test
	public void test_get_set_activityLevel() {
		String activityLevel = "Couch Potato";
		mySurvey.setActivityLevel(activityLevel);
		assertEquals("Couch Potato", mySurvey.getActivityLevel());
	}
	
	@Test
	public void test_get_set_parkname() {
		String parkName = "Yellowstone";
		mySurvey.setParkName(parkName);
		assertEquals("Yellowstone", mySurvey.getParkName());
	}
	
	@Test
	public void test_get_set_surveySum() {
		String parkCode = "GNTF";
		mySurvey.setParkCode(parkCode);
		assertEquals("GNTF", mySurvey.getParkCode());
	}
	
	@Test
	public void get_all_surveys() {
		List<SurveyResults> results  = dao.getAllSurveyResults();
		assertNotNull(results);
		mySurvey.setSurveyId(19);
		mySurvey.setParkCode("GNTC");
		mySurvey.setState("PA");
		mySurvey.setEmailAddress("hiker10@yahoo.com");
		dao.saveSurvey(19, emailAddress, state, activityLevel)
	}
//	
//	@Test
//	public void get_all_sites() {
//		List<Site> results = dao.getAllSites();
//		assertNotNull(results);	
//		mySite.setCampgroundID(4);
//		mySite.setSiteNumber(1);
//		mySite.setMaxOccupancy(6);
//		mySite.setAccessible(true);
//		mySite.setMaxRvLength("35");
//		mySite.setUtilities(false);
//		dao.createSite(mySite);
//		
//
//		List<Site> results2 = dao.getAllSites();
//		
//		assertNotNull(results2);	
//		assertEquals(results.size() + 1, results2.size());
//		
//	}
//	
//	@Test
//	public void get_create_sites() {
//		List<Site> results = dao.getAllSites();
//		assertNotNull(results);	
//		mySite.setCampgroundID(4);
//		mySite.setSiteNumber(1);
//		mySite.setMaxOccupancy(6);
//		mySite.setAccessible(false);
//		mySite.setMaxRvLength("35");
//		mySite.setUtilities(true);
//		dao.createSite(mySite);
//		
//
//		List<Site> results2 = dao.getAllSites();
//		
//		assertNotNull(results2);	
//		assertEquals(results.size() + 1, results2.size());
//		
//	}
//	@Test
//	public void get_sites_by_reservation_date() {
//		List<Site> results = dao.getAvailableSitesByReservationDate(1, LocalDate.of(2020, 03, 13), LocalDate.of(2020, 03, 15));
//		assertNotNull(results);	
//
//		resoDAO.createReservation(results.get(0).getSiteId(), "Hartmann", LocalDate.of(2020, 03, 13), LocalDate.of(2020, 03, 15));
//		
//		List<Site> results2 = dao.getAvailableSitesByReservationDate(1, LocalDate.of(2020, 03, 13), LocalDate.of(2020, 03, 15));
//		
//		assertNotNull(results2);	
//		assertEquals(results.size() - 1, results2.size());
//	}
//	@Test
	
}
