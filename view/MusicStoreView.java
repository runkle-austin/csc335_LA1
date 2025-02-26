package view;

import model.Album;
import model.MusicStore;
import model.Song;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MusicStoreView {
    private MusicStore musicStore;
    private Scanner scanner;

    public MusicStoreView() {
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
        List<Song> songs = musicStore.getSongsByTitle(title);

        if (songs.isEmpty()) {
            System.out.println("No songs found with title: " + title);
        } else {
            System.out.println("\n🎵 Songs Found:");
            for (Song song : songs) {
                System.out.println(song.getTitle() + " by " + song.getArtist());
            }
        }
    }

    private void searchSongByArtist() {
        System.out.print("Enter the artist's name: ");
        String artist = scanner.nextLine();
        List<Song> songs = musicStore.getSongsByArtist(artist);

        if (songs.isEmpty()) {
            System.out.println("No songs found by artist: " + artist);
        } else {
            System.out.println("\n🎤 Songs by " + artist + ":");
            for (Song song : songs) {
                System.out.println(song.getTitle());
            }
        }
    }

    private void searchAlbumByTitle() {
        System.out.print("Enter the album title: ");
        String title = scanner.nextLine();
        List<Album> albums = musicStore.getAlbumsByTitle(title);

        if (albums.isEmpty()) {
            System.out.println("No albums found with title: " + title);
        } else {
            System.out.println("\n📀 Albums Found:");
            for (Album album : albums) {
                System.out.println(album.getTitle() + " by " + album.getArtist());
                System.out.println("Songs:");
                for (Song song : album.getSongs()) {
                    System.out.println(" - " + song.getTitle());
                }
                System.out.println();
            }
        }
    }

    private void searchAlbumByArtist() {
        System.out.print("Enter the artist's name: ");
        String artist = scanner.nextLine();
        List<Album> albums = musicStore.getAlbumsByArtist(artist);

        if (albums.isEmpty()) {
            System.out.println("No albums found by artist: " + artist);
        } else {
            System.out.println("\n🎸 Albums by " + artist + ":");
            for (Album album : albums) {
                System.out.println(album.getTitle());
            }
        }
    }

    private void listAllAlbums() {
        List<Album> albums = musicStore.getAllAlbums();
        if (albums.isEmpty()) {
            System.out.println("No albums available.");
        } else {
            System.out.println("\n📀 All Albums:");
            for (Album album : albums) {
                System.out.println(album.getTitle() + " by " + album.getArtist());
            }
        }
    }

    private void listAllSongs() {
        List<Song> songs = musicStore.getAllSongs();
        if (songs.isEmpty()) {
            System.out.println("No songs available.");
        } else {
            System.out.println("\n🎶 All Songs:");
            for (Song song : songs) {
                System.out.println(song.getTitle() + " by " + song.getArtist());
            }
        }
    }

    public static void main(String[] args) {
        MusicStoreView view = new MusicStoreView();
        view.start();
    }
}

