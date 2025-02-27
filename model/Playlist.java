package model;

import java.util.ArrayList;

public class Playlist {

	private String playlistName;
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;

	public Playlist(String name) {
	    this.playlistName = name;
	    this.songs = new ArrayList<Song>();
	    this.albums = new ArrayList<Album>();
	}
	
	public String getName() {
	    return playlistName;
	}

	// adds song if not already in playlist
	public void addSong(Song song) {
	    if (songs.contains(song) == false) {
	        songs.add(song);
	    }
	}

	// adds album if not already in playlist
	public void addAlbum(String albumTitle) {
		
	}
	
	public String removeSong(String title) {
	    for(Song s: songs) {
	    	if(s.getTitle().equals(title)) {
	    		songs.remove(s);
	    		return title + " was removed\n";
	    	}
	    }
	    return title + " was not found\n"; 
	}

	public String getSongs() {
		String str = "";
		if (songs.isEmpty()) {
			return "This playlist is empty\n";
		} else {
			for(Song s: songs) {
				str += s.toString();
			}
		}
		return str;
	}
	
	public String getAllAlbums() {
		String str = "";
		if (albums.isEmpty()) {
			return "Currently No Albums\n";
		} else {
			for(Album a: albums) {
				str += a.toString();
			}
		}
		return str;
	}
	
}
