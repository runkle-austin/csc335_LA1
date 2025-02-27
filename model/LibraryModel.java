package model;

import java.util.ArrayList;
import java.util.HashMap;

public class LibraryModel {
	
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	private HashMap<String, Playlist> playlists;
	private ArrayList<Song> favoriteSongs;

	public LibraryModel() {
		songs = new ArrayList<>();
		albums = new ArrayList<>();
		playlists = new HashMap<>(); 
		favoriteSongs = new ArrayList<>();
	}

	public void addSongToLibrary(Song song) {
		if (!songs.contains(song)) {
			songs.add(song);
		}
	}

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
}
