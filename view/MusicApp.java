package view;

import model.MusicStore;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MusicApp {
    private MusicStore musicStore;
    private Scanner scanner;

    public MusicApp() {
        try {
            musicStore = new MusicStore(); // Load data from files
        } catch (FileNotFoundException e) {
            System.out.println("Error loading music store data: " + e.getMessage());
            System.exit(1); // Exit program if file is not found
        }
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n🎵 Welcome to the Music Store 🎵");
            System.out.println("1. Search for a song by title");
            System.out.println("2. Search for a song by artist");
            System.out.println("3. Search for an album by title");
            System.out.println("4. Search for an album by artist");
            System.out.println("5. List all albums");
            System.out.println("6. List all songs");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    searchSongByTitle();
                    break;
                case "2":
                    searchSongByArtist();
                    break;
                case "3":
                    searchAlbumByTitle();
                    break;
                case "4":
                    searchAlbumByArtist();
                    break;
                case "5":
                    listAllAlbums();
                    break;
                case "6":
                    listAllSongs();
                    break;
                case "7":
                    System.out.println("Goodbye! 🎶");
                    return; // Exit program
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void searchSongByTitle() {
        System.out.print("Enter the song title: ");
        String title = scanner.nextLine();
        String songs = musicStore.getSongsByTitle(title);
        System.out.print(songs);
        
    }

    private void searchSongByArtist() {
        System.out.print("Enter the artist's name: ");
        String artist = scanner.nextLine();
        String songs = musicStore.getSongsByArtist(artist);

        if (songs.isEmpty()) {
            System.out.println("No songs found by artist: " + artist);
        } else {
            System.out.println(songs);
        }
    }

    private void searchAlbumByTitle() {
        System.out.print("Enter the album title: ");
        String title = scanner.nextLine();
        String albums = musicStore.getAlbumsByTitle(title);
        
        System.out.print(albums);
    }

    private void searchAlbumByArtist() {
        System.out.print("Enter the artist's name: ");
        String artist = scanner.nextLine();
        String albums = musicStore.getAlbumsByArtist(artist);

        if (albums.isEmpty()) {
            System.out.println("No albums found by artist: " + artist);
        } else {
            System.out.print(albums);
        }
    }

 
    private void listAllAlbums() {
        System.out.print(musicStore.getAllAlbums());
    }
 

    private void listAllSongs() {
        System.out.print(musicStore.getSongs());
    }

    public static void main(String[] args) {
        MusicApp view = new MusicApp();
        view.start();
    }
}

