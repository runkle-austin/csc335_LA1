package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Rating;
import model.Song;



class testSong {

	@Test
	void testRatingSong() {
		Song s = new Song("Sticks", "Mother Mother");
		s.setRating(5);
		assertEquals(Rating.FIVE,s.getRating());
	}
	
	@Test
	void testSongToString() {
		Song s = new Song("Sticks", "Mother Mother");
		assertEquals("Sticks by Mother Mother", s.toString());
	}
	
	@Test
	void testgetTitle() {
		Song s = new Song("Sticks", "Mother Mother");
		assertEquals("Sticks", s.getTitle());
	}
	
	@Test
	void testgetArtist() {
		Song s = new Song("Sticks", "Mother Mother");
		assertEquals("Mother Mother", s.getArtist());
	}
	
	@Test
	void testCreateCopy() {
		Song s = new Song("Sticks", "Mother Mother");
		// tests if they are NOT the same object
		Song copy = s.createCopy();
		assertNotEquals(s, copy);
		// tests if title and artist are same
		assertEquals(s.getArtist(), copy.getArtist());
		assertEquals(s.getTitle(), copy.getTitle());
	}
	

}
