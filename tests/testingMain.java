package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Album;
import model.Song;

public class testingMain {

	public static void main(String[] args) {
		Song bit = new Song("Bit by Bit", "Mother Mother");
		ArrayList<Song> songList = new ArrayList<Song>();
		songList.add(bit);
		
		Album sticks = new Album("The Sticks", "Mother Mother", songList, "alt",LocalDate.of(2017, 1,1));
		String str = "The Sticks by Mother Mother\nSongs:\nBit by Bit";
		
		System.out.print(sticks.toString());

	}

}
