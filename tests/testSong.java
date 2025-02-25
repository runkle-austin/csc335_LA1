package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Rating;
import model.Song;



class testSong {

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
	
	//several tests for rating
		@Test
		void testRatingFiveSong() {
			Song s = new Song("LIVIDI SUI GOMITI", "Maneskin");
			s.setRating(5);
			assertEquals(Rating.FIVE,s.getRating());
		}
		
		@Test
		void testRatingFourSong() {
			Song s = new Song("LIVIDI SUI GOMITI", "Maneskin");
			s.setRating(4);
			assertEquals(Rating.FOUR,s.getRating());
		}
		
		@Test
		void testRatingThreeSong() {
			Song s = new Song("LIVIDI SUI GOMITI", "Maneskin");
			s.setRating(3);
			assertEquals(Rating.THREE,s.getRating());
		}
		
		@Test
		void testRatingTwoSong() {
			Song s = new Song("LIVIDI SUI GOMITI", "Maneskin");
			s.setRating(2);
			assertEquals(Rating.TWO,s.getRating());
		}
		
		@Test
		void testRatingOneSong() {
			Song s = new Song("LIVIDI SUI GOMITI", "Maneskin");
			s.setRating(1);
			assertEquals(Rating.ONE,s.getRating());
		}
		
		@Test
		void testGetNullRating() {
			Song s = new Song("LIVIDI SUI GOMITI", "Maneskin");
			assertEquals(null,s.getRating());
		}
	

}
