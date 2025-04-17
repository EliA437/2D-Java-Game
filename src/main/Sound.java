package src.main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL[] soundURL = new URL[30];  // Class-level array for storing sound URLs

    public Sound() {
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
    }

    public void setFile(int i) {
        // Ensure the index is valid
        if (i < 0 || i >= soundURL.length) {
            System.err.println("Invalid sound index: " + i);
            return;
        }

        // If a clip is already open, stop and close it
        if (clip != null && clip.isOpen()) {
            clip.stop();
            clip.flush();
            clip.close();
        }

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

    public void play() {
        if (clip != null) {
            clip.start();
        } else {
            System.err.println("Clip is null. Did you call setFile() with a valid index?");
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            System.err.println("Clip is null. Did you call setFile() with a valid index?");
        }
    }

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
