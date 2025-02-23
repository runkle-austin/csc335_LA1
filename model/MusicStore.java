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
			
			processAlbum(line);
			
			System.out.println(line);
		}
		
		scanner.close();
		
	}
	
	// creates album and songs
	private void processAlbum(String line) throws FileNotFoundException {
		File fr = new File(line);
		Scanner scanner = new Scanner(fr);
		
		// first line = album, artist, genre, year
		String firstLine = scanner.nextLine();
		String[] firstLineArray = firstLine.split(",");
		String albumTitle = firstLineArray[0];
		String artist = firstLineArray[1];
		String genre = firstLineArray[2];
		int year = Integer.parseInt(firstLineArray[3]);
		
		// each line has song title
		ArrayList<Song> songs = new ArrayList<Song>();
		while(scanner.hasNext()) {
			// adds new song from line
			Song s = new Song(scanner.nextLine(), artist);
			songs.add(s);
			songList.add(s);
		}
		Album album = new Album(albumTitle, artist, songs, genre, year);
		albumList.add(album);
		
		
		
		scanner.close();
	}
	
	public ArrayList<Song> getSongsByArtist(String artist) {
		return null;
		
	}
}
