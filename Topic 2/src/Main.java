// File: Main.java
// Handles user interaction for the playlist management application.
// Initialises the playlist with songs and provides an interactive menu to control playback.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        // Add some initial songs to the playlist
        playlist.addSong(new Song("Butterfly Effect", "Travis Scott"));
        playlist.addSong(new Song("Stay", "Kid Laroi"));
        playlist.addSong(new Song("Ransom", "Lil Tecca"));
        playlist.addSong(new Song("17", "Pink Sweat$"));
        playlist.addSong(new Song("Jack Brown", "Brent Faiyaz"));
        playlist.addSong(new Song("Lavender Sunflower", "Tory Lanez"));
        playlist.addSong(new Song("Lay You Down", "RINI"));

        // Display all songs in the playlist recursively
        System.out.println("Playlist:");
        playlist.displaySongs();

        // Show currently playing song, next song, previous song, and perform a shuffle play
        displayCurrentSong(playlist);
        displayNextSong(playlist);
        displayPreviousSong(playlist);
        performShufflePlay(playlist);

        // Start interactive menu
        runInteractiveMenu(playlist);
    }

    // Helper method to display the currently playing song
    private static void displayCurrentSong(Playlist playlist) {
        System.out.println("\nPlaying currently:");
        System.out.println(playlist.getCurrentSong());
    }

    // Helper method to display the next song in the playlist
    private static void displayNextSong(Playlist playlist) {
        System.out.println("\nPlaying next:");
        System.out.println(playlist.next());
    }

    // Helper method to display the previous song in the playlist
    private static void displayPreviousSong(Playlist playlist) {
        System.out.println("\nLast Played:");
        System.out.println(playlist.previous());
    }

    // Helper method to perform shuffle play and display the randomly selected song
    private static void performShufflePlay(Playlist playlist) {
        System.out.println("\nShuffle Play:");
        System.out.println(playlist.shufflePlay());
    }

    // Method to run the interactive menu, allowing user to control playback
    private static void runInteractiveMenu(Playlist playlist) {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {
            // Display menu options to the user
            System.out.println("\nMenu:");
            System.out.println("1. Play current song");
            System.out.println("2. Play next song");
            System.out.println("3. Play previous song");
            System.out.println("4. Shuffle play");
            System.out.println("5. Display all songs");
            System.out.println("6. Exit");
            System.out.print("Enter a number (1-6) to choose an option: ");
            command = scanner.nextLine();

            // Handle user's menu choice
            switch (command) {
                case "1":
                    displayCurrentSong(playlist);
                    break;
                case "2":
                    displayNextSong(playlist);
                    break;
                case "3":
                    displayPreviousSong(playlist);
                    break;
                case "4":
                    performShufflePlay(playlist);
                    break;
                case "5":
                    System.out.println("\nPlaylist:");
                    playlist.displaySongs();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    command = "exit"; // End loop
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 6."); // Error message for invalid input
                    break;
            }
        }
        scanner.close(); // Close scanner resource
    }
}