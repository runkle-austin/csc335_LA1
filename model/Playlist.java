package model;

import java.util.ArrayList;

public class Playlist {

	private String playlistName;
	private ArrayList<Song> songs;

	public Playlist(String name) {
	    this.playlistName = name;
	    this.songs = new ArrayList<>();
	}

	public void addSong(Song song) {
	    if (songs.contains(song) == false) {
	        songs.add(song);
	    }
	}

	public void removeSong(Song song) {
	    songs.remove(song);
	}

	public ArrayList<Song> getSongs() {
	    return new ArrayList<>(songs);
	}

	public String getName() {
	    return playlistName;
	}
}

