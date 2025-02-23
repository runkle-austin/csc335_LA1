package model;

import java.util.ArrayList;

public class Artist {
	private String artist;
	private ArrayList<Song> songs = new ArrayList<Song>();
	private ArrayList<Album> albums = new ArrayList<Album>();
	
	
	public Artist(String artist) {
		this.artist = artist;
	}
	
	// protected so user can not add albums through view
	protected void addAlbum(Album album) {
		albums.add(album);
	}
	
	// protected so user can not add songs through view
	protected void addSong(Song s) {
		songs.add(s);	
	}
	
	// creates deep copy of songList by an artist
	public ArrayList<Song> getSongs(){
		ArrayList<Song> copySongs = new ArrayList<Song>();
		for (Song s: this.songs){
			// create copy of individual songs
			copySongs.add(s.createCopy());
		}
		return copySongs;
	}
	
	// creates deep copy of the list of albums by an artist
	public ArrayList<Album> getAlbums(){
		ArrayList<Album> copyAlbums = new ArrayList<Album>();
		for (Album a: this.albums){
			// create copy of individual songs
			Album tempAlbum = new Album(a.getTitle(), a.getArtist(), a.getSongs(), a.getGenre(), a.getYear());
			copyAlbums.add(tempAlbum);
		}
		return copyAlbums;
	}
	
	public String getArtistName() {
		return artist;
	}
	
	
}
