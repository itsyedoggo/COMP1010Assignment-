import java.util.ArrayList;
import java.util.Random;

public class Playlist {
    private ArrayList<Song> songs; //Store list of songs in playlist 
    int currentSongIndex; //tracks index of current (playing) song 

    //Initialises the playlist 
    public Playlist() { 
        songs = new ArrayList<>();
        currentSongIndex = -1; // No song is playing initially
    }

    //If it is the first song, set it as the current song 
    public void addSong(Song song) { //Add new song to playlist 
        songs.add(song);
        if (currentSongIndex == -1) {
            currentSongIndex = 0; // Set the first song if the playlist was empty
        }
    }

    public void removeSong(Song song) { // Removes song from playlist 
        songs.remove(song);
        if (songs.isEmpty()) {
            currentSongIndex = -1; // Reset if the playlist is empty
        } else if (currentSongIndex >= songs.size()) {
            currentSongIndex = songs.size() - 1; // Adjust index if needed
        }
    }
    
    //Returns the currently playing song, or null if no songs are available
    public Song getCurrentSong() {
        if (songs.isEmpty() || currentSongIndex == -1) {
            return null; // No song available
        }
        return songs.get(currentSongIndex);
    }

    //Advance to next song in the playlist.
    public Song next() {
        if (songs.isEmpty()) {
            return null; // No song available
        }
        currentSongIndex = (currentSongIndex + 1) % songs.size(); // Loop to the start if at the end
        return songs.get(currentSongIndex);
    }

    // Moves to the previous song in the playlist.
    public Song previous() {
        if (songs.isEmpty()) {
            return null; // No song available
        }
        currentSongIndex = (currentSongIndex - 1 + songs.size()) % songs.size(); // Loop to the end if at the start
        return songs.get(currentSongIndex);
    }

    // Selects and plays a random song from the playlist.
    public Song shufflePlay() {
        if (songs.isEmpty()) {
            return null; // No song available
        }
        Random random = new Random();
        currentSongIndex = random.nextInt(songs.size());
        return songs.get(currentSongIndex);
    }

    //Output/display songs in playlist 
    public void displaySongs() {
        displaySongsRecursive(0);
    }

    private void displaySongsRecursive(int index) {
        if (index < songs.size()) {
            System.out.println(songs.get(index));
            displaySongsRecursive(index + 1);
        }
    }
    
    // Returns the list of all songs in the playlist
    public ArrayList<Song> getSongs() {
        return songs;
    }
}
