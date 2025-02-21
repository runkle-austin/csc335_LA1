package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Song;

class testAlbum {

	@Test
	void testAlbumToString() {
		Song bit = new Song("Bit by Bit", "Mother Mother");
		ArrayList<Song> songList = new ArrayList<Song>();
		songList.add(bit);
		Album sticks = new Album("The Sticks", "Mother Mother", songList, "alt",LocalDate.of(2017, 1,1));
		
		String str = "The Sticks by Mother Mother\nSongs:\nBit by Bit\n";
		assertEquals(str, sticks.toString());
	}
	
	@Test
	void testGetters() {
		Song bit = new Song("Bit by Bit", "Mother Mother");
		ArrayList<Song> songList = new ArrayList<Song>();
		songList.add(bit);
		Album sticks = new Album("The Sticks", "Mother Mother", songList, "alt",LocalDate.of(2017, 1,1));
		
		String title = "The Sticks";
		String artist = "Mother Mother";
		String genre = "alt";
		LocalDate year = LocalDate.of(2017, 1,1);
		
		assertEquals(title, sticks.getTitle());
		assertEquals(artist, sticks.getArtist());
		assertEquals(genre, sticks.getGenre());
		assertEquals(year, sticks.getYear());
	}
	
	@Test
	void testDeepCopy() {
		Song bit = new Song("Bit by Bit", "Mother Mother");
		ArrayList<Song> songList = new ArrayList<Song>();
		songList.add(bit);
		Album sticks = new Album("The Sticks", "Mother Mother", songList, "alt",LocalDate.of(2017, 1,1));
		
		ArrayList<Song> copySongs = sticks.getSongs();
		// tests that they are NOT the same list
		assertNotEquals(copySongs, songList);
		// tests that the first song is NOT the same song
		assertNotEquals(copySongs.get(0), songList.get(0));
		// tests that the first song of the copy has the same title (implying it is a copy of the song)
		assertEquals(copySongs.get(0).getTitle(), songList.get(0).getTitle());
		
	}

}
