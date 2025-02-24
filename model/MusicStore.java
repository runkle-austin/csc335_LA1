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
		
		// TODO change to correct file name
		File fr = new File("/Users/ryangillson/Downloads/LA 1/albums/albums.txt");
		Scanner scanner = new Scanner(fr);
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			line = line.replace(",", "_");
			line += ".txt";
			
			artists.add(processAlbum(line));
			
			System.out.println(line);
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
			Song s = new Song(scanner.nextLine(), artistName);
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
	
	public ArrayList<Song> getSongsByArtist(String artist) {
		return null;
		
	}
}
