package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import model.MusicStore;

class testMusicStore {

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
		String returnStr = musicStore.getAlbumsByTitle("Begin Again");
		assertEquals(returnStr, str);
	}

}
