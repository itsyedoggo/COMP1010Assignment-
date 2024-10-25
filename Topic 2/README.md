# Music Library Management

This project implements a **Music Library Management System** in Java. It provides functionality to manage songs, organise them in playlists, and navigate through them with features such as playing the next or previous song, as well as shuffle play.

## Project Structure

- **Song.java**: Defines a `Song` class to store song information, including the song title and artist.
- **Playlist.java**: Defines a `Playlist` class to manage a list of songs. It provides methods to add, remove, navigate, and shuffle play songs.
- **Main.java**: The main entry point that initialises the playlist, adds songs, and allows users to interact with the playlist through a simple interactive menu.

## Features

### Song Class (Song.java)
The `Song` class represents individual songs with the following properties and methods:

- **Properties**:
  - `title`: Title of the song.
  - `artist`: Artist of the song.
  
- **Methods**:
  - `getTitle()`: Returns the title of the song.
  - `getArtist()`: Returns the artist of the song.
  - `toString()`: Returns a formatted string with the song title and artist.

### Playlist Class (Playlist.java)
The `Playlist` class manages a collection of `Song` objects and supports the following operations:

- **addSong(Song song)**: Adds a song to the playlist.
- **removeSong(Song song)**: Removes a specified song from the playlist.
- **getCurrentSong()**: Returns the currently playing song.
- **next()**: Advances to the next song in the playlist.
- **previous()**: Goes back to the previous song in the playlist.
- **shufflePlay()**: Selects a random song from the playlist.
- **displaySongs()**: Displays all songs in the playlist recursively.

### Main Program (Main.java)
The `Main` class demonstrates the `Playlist` functionality through a simple command-line menu that allows users to:

1. Play the current song.
2. Play the next song.
3. Play the previous song.
4. Shuffle play a random song.
5. Display all songs in the playlist.
6. Exit the program.

## How to Run the Program

1. Compile the Java files:

   ```sh
   javac Song.java Playlist.java Main.java
   ```
   
2. Run the `Main` program:

   ```sh
   java Main
   ```

3. Follow the on-screen menu prompts to interact with the playlist.
   
