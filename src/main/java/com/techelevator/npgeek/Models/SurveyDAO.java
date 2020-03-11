package com.techelevator.npgeek.Models;

public interface SurveyDAO {

	
	
	
	
	List<Song> getAllSongs();
	List<Song> getAllRequests();
	boolean saveRequest(Song request);
}
}
