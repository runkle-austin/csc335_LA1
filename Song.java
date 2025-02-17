package model;

public class Song {
	// Instance Variables
	private String title;
	private String artist;
	private int rating;
	// private Album album; (add when we make album class)
	
	// Constructor
	
	private Song (String title, String artist) {
		this.title = title;
		this.artist = artist;
		// can't have default value
		this.rating = 0;

		// this.album = Album
	}
	
	//Methods 
	private void setTitle(String title) {
		this.title = title;
	}
	
	private void setArtist(String artist) {
		this.artist = artist;
	}
	
	private void setRating(int rating) {
		this.rating = rating;
	}
	
	private String getTitle() {
		return title;
	}
	
	private String getArtist() {
		return artist;
	}
	
	private int Rating() {
		return rating;
	}

	
}
