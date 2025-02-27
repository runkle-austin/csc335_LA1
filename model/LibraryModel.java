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
	/*
	public void addAlbumToLibrary(Album album) {
		if (!albums.contains(album)) {
			albums.add(album);
			for (Song song : album.getSongs()) {
				addSongToLibrary(song);
			}
		}
	}

	public ArrayList<Song> getSongs() {
		return new ArrayList<>(songs);
	}

	public ArrayList<Album> getAlbums() {
		return new ArrayList<>(albums);
	}

	public String rateSong(Song song, int rating) {
		if (rating < 1 || rating > 5) {
			return "Invalid rating. Try again.";
		}
		song.setRating(rating);
		if (rating == 5) {
			markSongAsFavorite(song);
		}
		return "Song was rated " + rating;
	}

	public void markSongAsFavorite(Song song) {
		if (!favoriteSongs.contains(song)) {
			favoriteSongs.add(song);
			System.out.println(song.getTitle() + " has been added to favorites.");
		}
	}

	public void createPlaylist(String name) {
		if (!playlists.containsKey(name)) {
			playlists.put(name, new Playlist(name));
		}
	}

	public void addSongToPlaylist(String playlistName, Song song) {
		if (playlists.containsKey(playlistName)) {
			playlists.get(playlistName).addSong(song);
		}
	}

	public void removeSongFromPlaylist(String playlistName, Song song) {
		if (playlists.containsKey(playlistName)) {
			playlists.get(playlistName).removeSong(song);
		}
	}

	public Playlist getPlaylist(String name) {
		return playlists.get(name);
	}

	public ArrayList<Song> getFavoriteSongs() {
		return new ArrayList<>(favoriteSongs);
	}
	*/
}
