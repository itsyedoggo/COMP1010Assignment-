// File: Song.java
// Represents a song with a title and artist, supporting basic retrieval and display functionalities.

public class Song {
    private String title;  // Title of the song
    private String artist; // Artist of the song

    // Constructs a Song with a specified title and artist
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Returns the title of the song
    public String getTitle() {
        return title;
    }

    // Returns the artist of the song
    public String getArtist() {
        return artist;
    }

    // Returns a formatted string representing the song in "Title by Artist" format
    @Override
    public String toString() {
        return title + " by " + artist;
    }
}
