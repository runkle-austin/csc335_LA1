package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Playlist;
import model.Song;

class testPlaylist {
	
	@Test 
	void testGetPlayList() {
		Playlist playlist = new Playlist("2025");
		assertEquals(playlist.getName(), "2025");
	}
	
	@Test
	void testSongs() {
		Playlist playlist = new Playlist("test");
		Song s = new Song("Big Sur", "Jack Johnson", "All The Light Above It Too");
		ArrayList<Song> songs = new ArrayList<Song>();
		assertEquals(playlist.getSongs(), songs);
		playlist.addSong(s);
		songs.add(s);
		assertEquals(playlist.getSongs(), songs);
		playlist.removeSong(s);
		ArrayList<Song> songs2 = new ArrayList<Song>();
		assertEquals(playlist.getSongs(), songs2);
	}

}