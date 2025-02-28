package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

// the LibraryModel class stores user information about what they have saved from the music store
public class LibraryModel {
	private MusicStore musicStore;
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	private ArrayList<Playlist> playlists;
	private ArrayList<Song> favoriteSongs;

	public LibraryModel() throws FileNotFoundException {
		musicStore = new MusicStore();
		songs = new ArrayList<>();
		albums = new ArrayList<>();
		playlists = new ArrayList<>(); 
		favoriteSongs = new ArrayList<>();
	}
	// finds song from songName and artistName in music store and creates copy
	// if song doesn't exist, song = null
	public Song createSong(String songName, String artistName) {
		if (songName == null || artistName == null || songName.isEmpty() || artistName.isEmpty()) {
			return null;
		}
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

	// this method gets all of the songs in the library by artist
	public String getSongsByArtist(String artist) {
		String result = "Songs by " + artist + "\n";
		
		// loop through all the songs in the library
		for (Song song: songs) {
			if (song.getArtist().equals(artist)) {
			result += song.toString();
			}
		}
		
		if (result.equals("")) {
			return "No songs by " + artist; 
		} else {
			return result;
		}
	}
	
	// this method gets all of the songs in the library by title
	public String getSongsByTitle(String title) {
		String result = "Songs named" + title + "\n";
		
		// loop through all the songs in the library
		for (Song song: songs) {
			if (song.getTitle().equals(title));
			result += song.toString();
		}
		
		if (result.equals("")) {
			return "No songs with title " + title; 
		} else {
			return result;
		}
	}
	
	public String getAlbumsByTitle(String title) {
		String result = "";
		
		// loop through all the albums in the library
		for (Album album: albums) {
			if (album.getTitle().equals(title));
			result += album.toString();
		}
		
		if (result.equals("")) {
			return "No albums with title " + title; 
		} else {
			return "Albums named " + title + "\n" + result;
		}
	}
	
	public String getAlbumsByArtist(String artist) {
		String result = "";
		
		// loop through all the albums in the library
		for (Album album: albums) {
			if (album.getArtist().equals(artist));
			result += album.toString();
		}
		
		if (result.equals("")) {
			return "No songs with title " + artist; 
		} else {
			return "Albums by " + artist + "\n" + result;
		}
	}
	
	// this method creates a new playlist and adds it to the arraylist of playlists
	public void createPlaylist(String name) {
		playlists.add(new Playlist(name));
	}
	
	// this method adds a song to a specific playlist in the playlist arraylist
	public String addSongToPlaylist(String playlistName, String songTitle, String artist) {
		for (Playlist p: playlists) {
			if (p.getName().equals(playlistName)) {
				Song song = createSong(songTitle, artist);
				if (song == null) {
					return "Song was not found in music store";
				}
				p.addSong(song);
				return songTitle + " has been added to playlist" + playlistName + "\n";
			}
		}
		// if the playlist does not exist
		return playlistName + " has not been created " + "\n"; 
		
	}
	
	public String addAlbumToPlaylist(String playlistName, String albumTitle, String artist) {
		for (Playlist p: playlists) {
			if (p.getName().equals(playlistName)) {
				Album album = musicStore.getAlbumByTitleAndArtist(albumTitle, artist);
				if (album.equals(null)) {
					return "Album was not found in music store";
				}
				p.addAlbum(albumTitle);
				return albumTitle + " has been added to playlist" + playlistName + "\n";
			}
		}
		// if the playlist does not exist
		return playlistName + " has not been created " + "\n"; 
	}
	
	public String getPlaylistByName(String name) {
		for (Playlist p : playlists) {
			if (p.getName().equals(name)) {
				return p.getName() + "\n" + p.getSongs();
			}
		}
		// if the playlist does not exist
		return name + " has not been created " + "\n"; 
	}
	
	public String removeSongFromPlaylist(String playlistName, String songTitle) {
		// loop through the playlists
		for (Playlist p: playlists) {
			// if the playlist is found remove the song from the playlist
			if (p.getName().equals(playlistName)) {
				p.removeSong(songTitle);
				return songTitle + " has been removed from playlist" + playlistName;
			}
		}
		
		// if the playlist does not exist
		return playlistName + " does nto exist " + "\n"; 
	}
	
	// list all songs by title
	public String allSongs() {
		String str = "";
		//search through all of the songs in library
		for (Song s: songs) {
			str += s.getTitle() + "\n";
		}
		if (str.equals("")) {
			return "No songs in library\n";
		}
		return "Here is a list of all songs in your library\n" + str;
	}
	
	public String allArtists() {
		String str = "";
		//search through all of the songs in library
		for (Song s: songs) {
			// check if the artist has already been added to the string
			if (str.contains(s.getArtist()) == false) {
				str += s.getArtist() + "\n";
			}
		}
		//check if str has had any artists added to it
		if (str.equals("")) {
			return "No artists in library\n";
		}
		return "Here is a list of all artists in your library\n" + str;
	}
	
	public String allAlbums() {
		String str = "";
		//search through all of the songs in library
		for (Album a: albums) {
			str += a.getTitle() + "\n";
		}
		if (str.equals("")) {
			return "No albums in library\n";
		}
		return "Here is a list of all albums in your library\n" + str;
	}
	
	public String allPlaylists() {
		String str = "";
		//search through all of the songs in library
		for (Playlist p: playlists) {
			str += p.getName() + "\n";
		}
		if (str.equals("")) {
			return "No playlists in library\n";
		}
		return "Here is a list of all playlists in your library\n" + str;
	}
	
	public String favoriteSongs() {
		String str = "";
		//search through all of the songs in library
		for (Song p: favoriteSongs) {
			str += p.toString() + "\n";
		}
		if (str.equals("")) {
			return "No playlists in library\n";
		}
		return "Here is a list of all playlists in your library\n" + str;
	}
	
	public String rateSong(String song, String artist, int rating) {
		// find the song
		for (Song s: songs) {
			if (s.getTitle().equals(song) && s.getArtist().equals(artist)) {
				//rate the song and tell the user it has been rated
				s.setRating(rating);
				//add the song to the list of favorite songs
				if (rating == 5) {
					favoriteSongs.add(s);
				}
				return song + "has been rated\n";
			}
		}
		
		// if the song was not found dont rate it
		return "Song was not found";
	}
	

}
