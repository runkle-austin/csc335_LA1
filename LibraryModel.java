package model;
import java.util.ArrayList;

public class LibraryModel {
	
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	
	public LibraryModel() {
		songs  = new ArrayList<>();
		albums = new ArrayList<>();
	}
	
	public void addSongToLibrary(Song song) {
		songs.add(song);
	}
	
	public void addAlbumToLibrary(Album album) {
		albums.add(album);
		//add all of the songs in the album
		for (Song song: album.getSongs()) {
			songs.add(song);
		}
	}

	public void createPlaylist(String name) {
		// TODO Auto-generated method stub
		
	}

	public Song[] getSongs() {
		// TODO Auto-generated method stub
		return null;
	}

	public String rateSong(Song song, int rating) {
		// check if rating is between 1 and 5 inclusive
		if (rating == 5) {
			// set to favorite
		}
		if (1 <= rating && rating <= 5) {
			song.setRating(rating);
			return "Song was rated " + rating;
		}
		else {
			return "Invalid rating try again";
		}
	}

	
	//
}
