package view;

import model.Album;
import model.MusicStore;
import model.Song;
import model.LibraryModel;
import model.Playlist;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MusicApp {
    private MusicStore musicStore;
    private LibraryModel libraryModel;
    private Scanner scanner;

    public MusicApp() {
        try {
            musicStore = new MusicStore(); // Load data from files
            libraryModel = new LibraryModel(); // Initialize user library
        } catch (FileNotFoundException e) {
            System.out.println("Error loading music store data: " + e.getMessage());
            System.exit(1); // Exit program if file is not found
        }
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n🎵 Welcome to the Music Store 🎵");
            System.out.println("1. Search for a song by title (Store)");
            System.out.println("2. Search for a song by artist (Store)");
            System.out.println("3. Search for an album by title (Store)");
            System.out.println("4. Search for an album by artist (Store)");
            System.out.println("5. Search for a song by title (Library)");
            System.out.println("6. Search for a song by artist (Library)");
            System.out.println("7. Search for an album by title (Library)");
            System.out.println("8. Search for an album by artist (Library)");
            System.out.println("9. Search for a playlist by name");
            System.out.println("10. Create a playlist");
            System.out.println("11. Add a song to a playlist");
            System.out.println("12. Add an album to a playlist");
            System.out.println("13. Remove a song from a playlist");
            System.out.println("14. Add a song to the library");
            System.out.println("15. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": searchSongByTitleStore(); break;
                case "2": searchSongByArtistStore(); break;
                case "3": searchAlbumByTitleStore(); break;
                case "4": searchAlbumByArtistStore(); break;
                case "5": searchSongByTitleLibrary(); break;
                case "6": searchSongByArtistLibrary(); break;
                case "7": searchAlbumByTitleLibrary(); break;
                case "8": searchAlbumByArtistLibrary(); break;
                case "9": searchPlaylistByName(); break;
                case "10": createPlaylist(); break;
                case "11": addSongToPlaylist(); break;
                case "12": addAlbumToPlaylist(); break;
                case "13": removeSongFromPlaylist(); break;
                case "14": songToLibrary(); break;
                case "15":
                    System.out.println("Goodbye! 🎶");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void searchSongByTitleStore() {
        System.out.print("Enter the song title: ");
        String title = scanner.nextLine();
        String result = musicStore.getSongsByTitle(title);
        System.out.println(result);
    }

    private void searchSongByArtistStore() {
        System.out.print("Enter the artist's name: ");
        String artist = scanner.nextLine();
        String result = musicStore.getSongsByArtist(artist);
        System.out.println(result.isEmpty() ? "No songs found by artist: " + artist : result);
    }

    private void searchAlbumByTitleStore() {
        System.out.print("Enter the album title: ");
        String title = scanner.nextLine();
        String result = musicStore.getAlbumsByTitle(title);
        System.out.println(result);
    }

    private void searchAlbumByArtistStore() {
        System.out.print("Enter the artist's name: ");
        String artist = scanner.nextLine();
        String result = musicStore.getAlbumsByArtist(artist);
        System.out.println(result.isEmpty() ? "No albums found by artist: " + artist : result);
    }

    private void searchSongByTitleLibrary() {
        System.out.print("Enter the song title: ");
        String title = scanner.nextLine();
        String result = libraryModel.getSongsByTitle(title);
        System.out.println(result);
    }

    private void searchSongByArtistLibrary() {
        System.out.print("Enter the artist's name: ");
        String artist = scanner.nextLine();
        String result = libraryModel.getSongsByArtist(artist);
        System.out.println(result.isEmpty() ? "No songs found by artist: " + artist : result);
    }

    private void searchAlbumByTitleLibrary() {
        System.out.print("Enter the album title: ");
        String title = scanner.nextLine();
        String result = libraryModel.getAlbumsByTitle(title);
        System.out.println(result);
    }

    private void searchAlbumByArtistLibrary() {
        System.out.print("Enter the artist's name: ");
        String artist = scanner.nextLine();
        String result = libraryModel.getAlbumsByArtist(artist);
        System.out.println(result.isEmpty() ? "No albums found by artist: " + artist : result);
    }

    private void searchPlaylistByName() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        String result = libraryModel.getPlaylistByName(name);
        System.out.println(result);
    }

    private void createPlaylist() {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();
        libraryModel.createPlaylist(name);
        System.out.println("Playlist '" + name + "' created successfully.");
    }

    private void addSongToPlaylist() {
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        System.out.print("Enter song title: ");
        String songTitle = scanner.nextLine();
        
        System.out.print("Enter artist title: ");
        String artitTitle = scanner.nextLine();
        
        Song s = libraryModel.createSong(songTitle, playlistName);
        libraryModel.addSongToPlaylist(playlistName, songTitle);
    }

    private void addAlbumToPlaylist() {
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        System.out.print("Enter album title: ");
        String albumTitle = scanner.nextLine();
        libraryModel.addAlbumToPlaylist(playlistName, albumTitle);
    }

    private void removeSongFromPlaylist() {
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        System.out.print("Enter song title: ");
        String songTitle = scanner.nextLine();
        libraryModel.removeSongFromPlaylist(playlistName, songTitle);
    }
    
    private void songToLibrary() {
        System.out.print("Enter song title: ");
        String songTitle = scanner.nextLine();
        System.out.print("Enter artist name: ");
        String artistName = scanner.nextLine();
        System.out.print(libraryModel.addSongToLibrary(songTitle,artistName));
    }

    public static void main(String[] args) {
        MusicApp view = new MusicApp();
        view.start();
    }
}


