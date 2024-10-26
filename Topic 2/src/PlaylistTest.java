import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {

    private Playlist playlist; // Playlist object used for testing
    private Song song1, song2, song3; // Sample songs used across tests

    // Sets up the test environment by initialising playlist and sample songs
    @BeforeEach
    void setUp() {
        playlist = new Playlist(); 
        song1 = new Song("Song 1", "Artist 1"); 
        song2 = new Song("Song 2", "Artist 2");
        song3 = new Song("Song 3", "Artist 3");
    }

    // Tests adding a song to the playlist
    @Test
    void testAddSong() {
        playlist.addSong(song1);

        // Assert: Playlist should contain 1 song after adding
        assertEquals(1, playlist.getSongs().size(), "Playlist should contain 1 song after adding.");

        // Assert: The added song's format should match expectations
        assertEquals("Song 1 by Artist 1", playlist.getSongs().get(0).toString(), "The song should be formatted as 'Song 1 by Artist 1'.");
    }

    // Tests removing a song from the playlist and adjusting the current song index if necessary
    @Test
    void testRemoveSong() {
        playlist.addSong(song1);
        playlist.addSong(song2);

        // Act: Remove the first song from the playlist
        playlist.removeSong(song1);

        // Assert: Playlist should contain 1 song after removal
        assertEquals(1, playlist.getSongs().size(), "Playlist should contain 1 song after removing.");

        // Assert: The remaining song should be 'Song 2 by Artist 2'
        assertEquals("Song 2 by Artist 2", playlist.getSongs().get(0).toString(), "Remaining song should be 'Song 2 by Artist 2'.");
    }

    // Tests the next song functionality, including looping back to the first song
    @Test
    void testNextSong() {
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        // Assert: Navigating to the next songs in sequence
        assertEquals(song2, playlist.next(), "Next song should be 'Song 2'.");
        assertEquals(song3, playlist.next(), "Next song should be 'Song 3'.");
        assertEquals(song1, playlist.next(), "Next song should loop back to 'Song 1'.");
    }

    // Tests the previous song functionality, ensuring it loops correctly
    @Test
    void testPreviousSong() {
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        playlist.next(); // Move to Song 2 for setup
        assertEquals(song1, playlist.previous(), "Previous song should be 'Song 1'."); // Should loop back to Song 1
    }

    // Tests shuffle play to ensure a randomly selected song is in the playlist
    @Test
    void testShufflePlay() {
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        // Perform shuffle play
        Song shuffledSong = playlist.shufflePlay();

        // Assert: The shuffled song should be part of the playlist
        assertTrue(playlist.getSongs().contains(shuffledSong), "Shuffled song should be in the playlist.");
    }
}
