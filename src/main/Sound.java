package src.main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The Sound class handles audio playback for the game.
 * It allows for loading, playing, looping, and stopping sounds.
 */
public class Sound {
    // Clip object to handle audio playback
    Clip clip;
<<<<<<< HEAD
    URL[] soundURL = new URL[30];  // Class-level array for storing sound URLs
=======
    
    // Array to store sound file URLs (supports up to 30 sounds)
    URL soundURL[] = new URL[30];
>>>>>>> 14fe27e827c945a4892303c3110c9aeb632b8fea

    /**
     * Constructor: Initializes the sound files used in the game.
     */
    public Sound() {
<<<<<<< HEAD
        // Initialize sound URLs
        try {
            soundURL[1] = getClass().getResource("/src/res/sound/menu.wav"); // load menu music into 1
            if (soundURL[1] == null) {
                throw new Exception("Failed to load: 1.wav");
            }
            soundURL[2] = getClass().getResource("/src/res/sound/game_1.wav"); // load game music into 2
            if (soundURL[2] == null) {
                throw new Exception("Failed to load: 2.wav");
            }
        } catch (Exception e) {
            System.err.println("Error loading sound files: " + e.getMessage());
        }
=======
        // Load sound files into the array (Ensure the file paths are correct)
        soundURL[0] = getClass().getResource("/src/res/sound/your_face.wav"); // Example sound
        soundURL[1] = getClass().getResource("/src/res/sound/pretty_poison_loading_music.wav"); // Menu music
        soundURL[2] = getClass().getResource("/src/res/sound/gameplaymusic_1.wav"); // First soundtrack
>>>>>>> 14fe27e827c945a4892303c3110c9aeb632b8fea
    }

    /**
     * Loads and prepares an audio file for playback.
     * @param i Index of the sound in the soundURL array.
     */
    public void setFile(int i) {
<<<<<<< HEAD
        // Ensure the index is valid
        if (i < 0 || i >= soundURL.length) {
            System.err.println("Invalid sound index: " + i);
            return;
        }

        // If a clip is already open, stop and close it
=======
        // Stop and release any currently playing sound before loading a new one
>>>>>>> 14fe27e827c945a4892303c3110c9aeb632b8fea
        if (clip != null && clip.isOpen()) {
            clip.stop();
            clip.flush();
            clip.close();
        }
<<<<<<< HEAD

        try {
            // Ensure the URL is not null before attempting to load it
            if (soundURL[i] != null) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
                clip = AudioSystem.getClip();
                clip.open(ais);
            } else {
                System.err.println("Sound file at index " + i + " is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

=======
        try {   
            // Open the selected sound file
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace(); // Print errors if sound file cannot be loaded
        }
    }
    
    /**
     * Plays the loaded audio file.
     */
>>>>>>> 14fe27e827c945a4892303c3110c9aeb632b8fea
    public void play() {
        if (clip != null) {
            clip.start();
        } else {
            System.err.println("Clip is null. Did you call setFile() with a valid index?");
        }
    }

    /**
     * Loops the currently loaded audio file continuously.
     */
    public void loop() {
<<<<<<< HEAD
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            System.err.println("Clip is null. Did you call setFile() with a valid index?");
        }
=======
        clip.loop(Clip.LOOP_CONTINUOUSLY);
>>>>>>> 14fe27e827c945a4892303c3110c9aeb632b8fea
    }

    /**
     * Stops the currently playing audio and releases resources.
     */
    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.flush();
            clip.close();
        } else {
            System.err.println("Clip is null. Cannot stop.");
        }
    }
}
