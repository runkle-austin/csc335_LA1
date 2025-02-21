package model;

public class Song {
	// Instance Variables
	private String title;
	private String artist;
	private Rating rating;
	// private Album album; (add when we make album class)
	
	// Constructor
	public Song (String title, String artist) {
		this.title = title;
		this.artist = artist;

		// this.album = Album
	}
	/* we don't want setters because a song's variables 
	   don't change (other then rating) */
	
	// Methods 
	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}
	
	// need to do something about this if hasn't been assigned
	public Rating getRating() {
		return rating;
	}

	// @pre rating >= 1, rating <= 5
	public void setRating(int rating) {
		this.rating = Rating.getRating(rating);
		if (rating == 5) {
			// add to favorites
		}
	}
	
	public Song createCopy() {
		return new Song(this.title, this.artist);
	}
	
	public String toString() {
		return title + " by " + artist;
	}
	
	

	
}