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
    
    // Array to store sound file URLs (supports up to 30 sounds)
    URL soundURL[] = new URL[30];

    /**
     * Constructor: Initializes the sound files used in the game.
     */
    public Sound() {
        // Load sound files into the array (Ensure the file paths are correct)
        soundURL[0] = getClass().getResource("/src/res/sound/your_face.wav"); // Example sound
        soundURL[1] = getClass().getResource("/src/res/sound/pretty_poison_loading_music.wav"); // Menu music
        soundURL[2] = getClass().getResource("/src/res/sound/gameplaymusic_1.wav"); // First soundtrack
    }

    /**
     * Loads and prepares an audio file for playback.
     * @param i Index of the sound in the soundURL array.
     */
    public void setFile(int i) {
        // Stop and release any currently playing sound before loading a new one
        if (clip != null && clip.isOpen()) {
            clip.stop();
            clip.flush();
            clip.close();
        }
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
    public void play() {
        clip.start();
    }

    /**
     * Loops the currently loaded audio file continuously.
     */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Stops the currently playing audio and releases resources.
     */
    public void stop() {
        clip.stop();
        clip.flush();
        clip.close();
    }
}
