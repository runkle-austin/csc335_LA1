package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
	
	private ArrayList<Album> albumList = new ArrayList<Album>();
	private ArrayList<Song> songList = new ArrayList<Song>();
	private ArrayList<Artist> artists = new ArrayList<Artist>();
	
	// reads the album file, calling process file on each line
	// creates MusicStore object
	public MusicStore() throws FileNotFoundException {
		
		// loads album file
		File fr = new File("albums/albums.txt");
		Scanner scanner = new Scanner(fr);
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			line = line.replace(",", "_");
			line += ".txt";
			line = "albums/" + line;
			
			
			artists.add(processAlbum(line));
		}
		
		scanner.close();
		
	}
	
	// creates album, songs, and artist objects
	private Artist processAlbum(String line) throws FileNotFoundException {
		File fr = new File(line);
		Scanner scanner = new Scanner(fr);
		
		// first line = album, artist, genre, year
		String firstLine = scanner.nextLine();
		String[] firstLineArray = firstLine.split(",");
		String albumTitle = firstLineArray[0];
		String artistName = firstLineArray[1];
		String genre = firstLineArray[2];
		int year = Integer.parseInt(firstLineArray[3]);
		
		Artist artist = new Artist(artistName);
		// each line has song title
		ArrayList<Song> songs = new ArrayList<Song>();
		while(scanner.hasNext()) {
			// adds new song from line
			Song s = new Song(scanner.nextLine(), artistName, albumTitle);
			songs.add(s);
			songList.add(s);
			artist.addSong(s);
		}
		Album album = new Album(albumTitle, artistName, songs, genre, year);
		albumList.add(album);
		artist.addAlbum(album);
		
		
		scanner.close();
		return artist;
	}
	
	// returns a string of songs by artist if artist is found, 
	// otherwise returns empty string
	public String getSongsByArtist(String artist) {
		ArrayList<Song> songs = new ArrayList<Song>();
		for (Song s: songList) {
			if (s.getArtist().equals(artist)) {
				songs.add(s);
			}
		}
		String str = "";
		for (Song s: songs) {
			str += s.toString();
		}
		return str;
	}
	
	// searches through artists until finding artist with desired name
	// adds all albums by artist to return String
	public String getAlbumsByArtist(String artist) {
		ArrayList<Album> albums = new ArrayList<Album>();
		for (Album a: albumList) {
			if (a.getArtist().equals(artist)) {
				albums.add(a);
			}
		}
		String str = "";
		for (Album a: albums) {
			str += a.toString();
		}
		return str;
	}

	
	public String getAlbumsByTitle(String title) {
		ArrayList<Album> albums = new ArrayList<Album>();
		for (Album a: albumList) {
			if (a.getTitle().equals(title)) {
				albums.add(a);
			}
		}
		String str = "";
		for (Album a: albums) {
			str = a.toString();
		}
		return str;
	}

	public String getSongsByTitle(String title) {
		String str = "";
		for(Song s: songList) {
			if(s.getTitle().equals(title)) {
				str += s.toString();
			}
		}
		return str;
	}
	
	// returns copy of song from title and artist if found, otherwise return null
	public Song getSongByTitleArtist(String title, String artist) {
		for(Song s: songList) {
			if(s.getTitle().equals(title) && (s.getArtist().equals(artist))) {
				return s.createCopy();
			}
		}
		return null;
	}
}
