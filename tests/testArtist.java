package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Artist;
import model.Song;

class testArtist {

	@Test 
	void testGetSongs() {
		Artist maneskin = new Artist("Maneskin");
		Song s = new Song("Fear for Nobody", "Maneskin");
		maneskin.addSong(s);
		System.out.println(maneskin.getSongs().get(0));
		//assertEquals(maneskin.getSongs().get(0), "Fear for Nobody by Maneskin");
	}
	
	@Test 
	void testGetName() {
		Artist maneskin = new Artist("Maneskin");
		assertEquals(maneskin.getArtistName(), "Maneskin");
	}
	
	@Test 
	void testAddAlbum() {
		Artist maneskin = new Artist("Maneskin");
		Song s = new Song("VALENTINE", "Maneskin");
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(s);
		Album a = new Album("RUSH!", "Maneskin", songs, "rock", 2023);
		maneskin.addAlbum(a);
		String str = "RUSH! by Maneskin\nSongs:\nVALENTINE\n";
		System.out.println(maneskin.getAlbums().get(0));
	}
	
	
	
	

}
