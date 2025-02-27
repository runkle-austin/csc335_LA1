package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import model.LibraryModel;
import model.Song;

class testLibraryModel {

	@Test
	void testAddValidSongToLibrary() throws FileNotFoundException {
		LibraryModel library = new LibraryModel();
		String str = "Green Eyes was added to Library";
		String returnString = library.addSongToLibrary("Green Eyes", "Coldplay");
		assertEquals(str,returnString);
	}
	
	@Test
	void testAddNONValidSongToLibrary() throws FileNotFoundException {
		LibraryModel library = new LibraryModel();
		String returnString = library.addSongToLibrary("Green", "Coldplay");
		String str = "Song could not be added; not found in MusicStore";
		assertEquals(str,returnString);
	}
	
	@Test
	void testAddDuplicateSongToLibrary() throws FileNotFoundException {
		LibraryModel library = new LibraryModel();
		String str = "Song could not be added; already in Library";
		
		// attempts to add song twice, storing returnString on second attempt
		library.addSongToLibrary("Green Eyes", "Coldplay");
		String returnString = library.addSongToLibrary("Green Eyes", "Coldplay");
		assertEquals(str,returnString);
		
	}
	

}
