package model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Album {
	// Instance Variables
	private ArrayList<Song> songList;
	private String artist;
	private String genre;
	private String title;
	private LocalDate year;
	
	// Constructor
	public Album (ArrayList<Song> songList, String artist, String genre,
			String title, LocalDate year) {
		this.songList = songList;
		this.artist = artist;
		this.genre = genre;
		this.title = title;
		this.year = year;
	}
	
	// Methods
	public void addSong(Song song) {
		songList.add(song);
	}
	
	public String getTitle() {
		return title;
	}
}
