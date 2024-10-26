import java.util.ArrayList;
import java.util.Random;

public class Playlist {
    private ArrayList<Song> songs; // Stores list of songs in the playlist
    private int currentSongIndex; // Tracks the index of the current (playing) song

    // Initialises the playlist with no songs initially
    public Playlist() {
        songs = new ArrayList<>();
        currentSongIndex = -1; // No song is playing initially
    }

    // Adds a new song to the playlist. Sets as the current song if it’s the first one added.
    public void addSong(Song song) {
        songs.add(song);
        if (currentSongIndex == -1) {
            currentSongIndex = 0;
        }
    }

    // Removes a song from the playlist and adjusts the current song index if necessary
    public void removeSong(Song song) {
        songs.remove(song);
        if (songs.isEmpty()) {
            resetCurrentSongIndex(); // Resets if the playlist becomes empty
        } else if (currentSongIndex >= songs.size()) {
            currentSongIndex = songs.size() - 1; // Adjust index if it was out of bounds
        }
    }

    // Returns the currently playing song, or null if no songs are available
    public Song getCurrentSong() {
        return isPlaylistEmpty() ? null : songs.get(currentSongIndex);
    }

    // Advances to the next song in the playlist and returns it
    public Song next() {
        if (isPlaylistEmpty()) return null;
        currentSongIndex = (currentSongIndex + 1) % songs.size(); // Loops back to the start if at the end
        return songs.get(currentSongIndex);
    }

    // Moves to the previous song in the playlist and returns it
    public Song previous() {
        if (isPlaylistEmpty()) return null;
        currentSongIndex = (currentSongIndex - 1 + songs.size()) % songs.size(); // Loops to the end if at the start
        return songs.get(currentSongIndex);
    }

    // Plays a random song from the playlist and sets it as the current song
    public Song shufflePlay() {
        if (isPlaylistEmpty()) return null;
        currentSongIndex = getRandomSongIndex();
        return songs.get(currentSongIndex);
    }

    // Displays all songs in the playlist using a recursive helper method
    public void displaySongs() {
        System.out.println("Displaying all songs in the playlist:");
        displaySongsRecursive(0); // Start recursion from the first song
    }

    // Recursive helper method to display songs starting from a given index
    private void displaySongsRecursive(int index) {
        if (index < songs.size()) {
            System.out.println(songs.get(index));
            displaySongsRecursive(index + 1); // Recursively call for the next song
        }
    }

    // Returns the list of all songs in the playlist
    public ArrayList<Song> getSongs() {
        return songs;
    }

    // Helper method to check if the playlist is empty
    private boolean isPlaylistEmpty() {
        return songs.isEmpty() || currentSongIndex == -1;
    }

    // Resets the current song index to indicate no song is playing
    private void resetCurrentSongIndex() {
        currentSongIndex = -1;
    }

    // Generates a random index within the bounds of the playlist
    private int getRandomSongIndex() {
        Random random = new Random();
        return random.nextInt(songs.size());
    }
}
