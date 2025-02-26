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

	// returns a deep copy of songs in playlist
	public ArrayList<Song> getSongs() {
		ArrayList<Song> copySongs = new ArrayList<Song>();
		for (Song s: this.songs){
			// create copy of individual songs
			copySongs.add(s.createCopy());
		}
		return copySongs;
	}

	public String getName() {
	    return playlistName;
	}
}
