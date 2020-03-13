package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.Park;

public class ParkTest {

	private Park park;
	
	@Before
	public void setup() {
		park = new Park();
		
		park.setParkCode("FMNP");
		park.setParkName("Florida Man's National Park");
		park.setState("Florida");
		park.setAcreage(420000);
		park.setElevationInFt(42);
		park.setMilesOfTrail(500.43f);
		park.setNumOfCampsites(1000);
		park.setClimate("Hot");
		park.setYearFounded(1860);
		park.setAnnualVisitors(1000000);
		park.setQuote("Gators are free if you can catch em!");
		park.setQuoteSource("Ponce de Leon");
		park.setDescription("What are you doing out here?");
		park.setEntryFee(42);
		park.setNumAnimalSpecies(1000);
	}
	
	@Test
	public void parkCodeWorks() {
		//Act
		park.getParkCode();
		//Assert
		Assert.assertEquals("FMNP", park.getParkCode());
	}

	@Test
	public void park_name_works() {
		//Act
		park.getParkName();
		//Assert
		Assert.assertEquals("Florida Man's National Park", park.getParkName());
	}
	
	@Test
	public void park_state_works() {
		//Act
		park.getState();
		//Assert
		Assert.assertEquals("Florida", park.getState());
	}
	
	@Test
	public void park_acreage_works() {
		//Act
		park.getAcreage();
		//Assert
		Assert.assertEquals(420000, park.getAcreage());
	}
	
	@Test
	public void park_elevation_works() {
		//Act
		park.getElevationInFt();
		//Assert
		Assert.assertEquals(42, park.getElevationInFt());
	}
	
	@Test
	public void park_miles_of_trail_works() {
		//Act
		float miles = park.getMilesOfTrail();
		//Assert
		
		float expectedMiles = 500.43f;
	
		Assert.assertEquals(expectedMiles, miles, 0);
	}
	
	@Test
	public void num_of_campsites_works() {
		//Act
		park.getNumOfCampsites();
		//Assert
		Assert.assertEquals(1000, park.getNumOfCampsites());
	}
	
	@Test
	public void climate_works() {
		//Act
		park.getClimate();
		//Assert
		Assert.assertEquals("Hot", park.getClimate());
	}
	
	@Test
	public void year_founded_works() {
		//Act
		park.getYearFounded();
		//Assert
		Assert.assertEquals(1860, park.getYearFounded());
	}
	
	@Test
	public void annual_visitors_works() {
		//Act
		park.getAnnualVisitors();
		//Assert
		Assert.assertEquals(1000000, park.getAnnualVisitors());
	}
	
	@Test
	public void quote_works() {
		//Act
		park.getQuote();
		//Assert
		Assert.assertEquals("Gators are free if you can catch em!", park.getQuote());
	}
	
	@Test
	public void quote_source_works() {
		//Act
		park.getQuoteSource();
		//Assert
		Assert.assertEquals("Ponce de Leon", park.getQuoteSource());
	}
	
	@Test
	public void description_works() {
		//Act
		park.getDescription();
		//Assert
		Assert.assertEquals("What are you doing out here?", park.getDescription());
	}
	
	@Test
	public void entry_fee_works() {
		//Act
		park.getEntryFee();
		//Assert
		Assert.assertEquals(42, park.getEntryFee());
	}
	
	@Test
	public void num_animal_species_works() {
		//Act
		park.getNumAnimalSpecies();
		//Assert
		Assert.assertEquals(1000, park.getNumAnimalSpecies());
	}
}
