package com.techelevator.npgeek;

import java.util.List;

public interface ParkDAO {
	
	public List<Park> getAllParks();
	public Park findParkByCode(String parkCode);
	public void createPark(Park park);
	public void updatePark(Park park);
	public void deletePark(Park park);

}
