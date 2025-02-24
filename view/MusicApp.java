package view;

import java.util.Scanner;

import model.LibraryModel;
import model.MusicStore;
import model.Song;

// This code was written with the assitance of chatGPT
public class MusicApp {
    private static MusicStore musicStore;
    private static LibraryModel userLibrary;
    private static Scanner scanner;

    // This function runs the musicApp until the user exits
    public static void main(String[] args) {
        try {
            musicStore = new MusicStore();
            userLibrary = new LibraryModel();
            scanner = new Scanner(System.in);

            boolean running = true;
            while (running) {
                System.out.println("Welcome to the Music App!");
                System.out.println("1. Search Music Store");
                System.out.println("2. Search User Library");
                System.out.println("3. Add Song to Library");
                System.out.println("4. Create Playlist");
                System.out.println("5. Rate Song");
                System.out.println("6. Mark Song as Favorite");
                System.out.println("7. Exit");
                
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        searchMusicStore();
                        break;
                    case "2":
                        searchUserLibrary();
                        break;
                    case "3":
                        addSongToLibrary();
                        break;
                    case "4":
                        createPlaylist();
                        break;
                    case "5":
                        rateSong();
                        break;
                    case "6":
                        markSongAsFavorite();
                        break;
                    case "7":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // if the user wants to search for a song by title
    private static void searchMusicStore() {
        System.out.println("Search by (1) Song Title (2) Artist (3) Album Title (4) Album Artist");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Enter song title:");
                String title = scanner.nextLine();
                for (Song song : musicStore.getSongsByTitle(title)) {
                    System.out.println(song);
                }
                break;
            case "2":
                System.out.println("Enter artist:");
                String artist = scanner.nextLine();
                for (Song song : musicStore.getSongsByArtist(artist)) {
                    System.out.println(song);
                }
                break;
            // Similarly implement for album title and artist
        }
    }

    private static void searchUserLibrary() {
        // Implement search for user library functionality
    }

    
    private static void addSongToLibrary() {
        System.out.println("Enter song title:");
        String title = scanner.nextLine();
        for (Song song : musicStore.getSongsByTitle(title)) {
            userLibrary.addSongToLibrary(song);
            System.out.println("Song added to library.");
        }
    }

    private static void createPlaylist() {
        System.out.println("Enter playlist name:");
        String name = scanner.nextLine();
        userLibrary.createPlaylist(name);
        System.out.println("Playlist created.");
    }

    private static void rateSong() {
        System.out.println("Enter song title to rate:");
        String title = scanner.nextLine();
        System.out.println("Enter rating (1-5):");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Song song : userLibrary.getSongs()) {
            if (song.getTitle().equals(title)) {
                userLibrary.rateSong(song, rating);
                System.out.println("Song rated.");
                return;
            }
        }
        System.out.println("Song not found.");
    }

    private static void markSongAsFavorite() {
        // Implement mark song as favorite
    }
}

