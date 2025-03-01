package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import model.Album;
import model.MusicStore;

class testMusicStore {

	@Test
	void testGetAlbumByTitle() throws FileNotFoundException {
		MusicStore musicStore = new MusicStore();
		String str = "Begin Again by Norah Jones, 2018, Pop\n"
				+ "Songs:\n"
				+ "My Heart Is Full\n"
				+ "Begin Again\n"
				+ "It Was You\n"
				+ "A Song with No Name\n"
				+ "Uh Oh\n"
				+ "Wintertime\n"
				+ "Just a Little Bit\n";
		String returnStr = musicStore.getAlbumsByTitle("Begin Again");
		assertEquals(returnStr, str);
	}
	
	@Test
	void testGetAlbumByArtist() throws FileNotFoundException {
		MusicStore musicStore = new MusicStore();
		String str = "Begin Again by Norah Jones, 2018, Pop\n"
				+ "Songs:\n"
				+ "My Heart Is Full\n"
				+ "Begin Again\n"
				+ "It Was You\n"
				+ "A Song with No Name\n"
				+ "Uh Oh\n"
				+ "Wintertime\n"
				+ "Just a Little Bit\n";
		String returnStr = musicStore.getAlbumsByArtist("Norah Jones");
		assertEquals(returnStr, str);
	}
	
	@Test
	void testGetSongsByArtist() throws FileNotFoundException {
		MusicStore musicStore = new MusicStore();
		String str = "My Heart Is Full by Norah Jones from album: Begin Again\n"
				+ "Begin Again by Norah Jones from album: Begin Again\n"
				+ "It Was You by Norah Jones from album: Begin Again\n"
				+ "A Song with No Name by Norah Jones from album: Begin Again\n"
				+ "Uh Oh by Norah Jones from album: Begin Again\n"
				+ "Wintertime by Norah Jones from album: Begin Again\n"
				+ "Just a Little Bit by Norah Jones from album: Begin Again\n";
		String returnStr = musicStore.getSongsByArtist("Norah Jones");
		assertEquals(returnStr, str);
	}
	
	@Test
	void testGetSongsByTitle() throws FileNotFoundException {
		MusicStore musicStore = new MusicStore();
		String str = "Begin Again by Norah Jones from album: Begin Again\n";
		String returnStr = musicStore.getSongsByTitle("Begin Again");
		assertEquals(returnStr, str);
	}
	
	@Test
	void testGetAlbumByTitleAndArtist() throws FileNotFoundException {
		MusicStore musicStore = new MusicStore();
		String str = "Begin Again by Norah Jones, 2018, Pop\n"
				+ "Songs:\n"
				+ "My Heart Is Full\n"
				+ "Begin Again\n"
				+ "It Was You\n"
				+ "A Song with No Name\n"
				+ "Uh Oh\n"
				+ "Wintertime\n"
				+ "Just a Little Bit\n";
		Album a1 = musicStore.getAlbumByTitleAndArtist("Begin Again", "Norah Jones");
		String returnStr = a1.toString();
		assertEquals(returnStr, str);
		Album a2 = musicStore.getAlbumByTitleAndArtist("Be", "Norah Jones");
		assertEquals(a2,null);
	}

}
