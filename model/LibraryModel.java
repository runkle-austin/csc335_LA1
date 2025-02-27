package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class LibraryModel {
	private MusicStore musicStore;
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	private HashMap<String, Playlist> playlists;
	private ArrayList<Song> favoriteSongs;

	public LibraryModel() throws FileNotFoundException {
		musicStore = new MusicStore();
		songs = new ArrayList<>();
		albums = new ArrayList<>();
		playlists = new HashMap<>(); 
		favoriteSongs = new ArrayList<>();
	}
	// finds song from songName and artistName in music store and creates copy
	// if song doesn't exist, song = null
	public Song createSong(String songName, String artistName) {
		return musicStore.getSongByTitleArtist(songName, artistName);
	}

	// searches through songs to see if a song is already in library
	public boolean duplicate(Song s) {
		for (Song currSong: songs) {
			if (currSong.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	public String addSongToLibrary(String songName, String artist) {
		Song s = createSong(songName, artist);
		if (s == null) {
			return "Song could not be added; not found in MusicStore";
		}
		if (duplicate(s)) {
			return "Song could not be added; already in Library";
		}
		songs.add(s);
		return songName + " was added to Library";
	}

	public String getSongsByArtist(String artist) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAlbumsByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAlbumsByArtist(String artist) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPlaylistByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public void createPlaylist(String name) {
		// TODO Auto-generated method stub
		
	}
	public void addSongToPlaylist(String playlistName, String songTitle) {
		// TODO Auto-generated method stub
		
	}
	public void addAlbumToPlaylist(String playlistName, String albumTitle) {
		// TODO Auto-generated method stub
		
	}
	public void removeSongFromPlaylist(String playlistName, String songTitle) {
		// TODO Auto-generated method stub
		
	}
	public String getSongsByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
}
