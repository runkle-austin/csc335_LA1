package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import model.MusicStore;

class testMusicStore {

	@Test
	void testConstructor() throws FileNotFoundException {
		MusicStore musicStore = new MusicStore();
		//System.out.println(musicStore.getSongs());
	}

}
