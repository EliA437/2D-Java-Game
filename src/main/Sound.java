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
    Clip clip;
    URL[] soundURL = new URL[30];

    public Sound() {
        try {
            soundURL[1] = getClass().getResource("/src/res/sound/pretty_poison_loading_music.wav");
            soundURL[2] = getClass().getResource("/src/res/sound/gameplaymusic_1.wav");
            
            for (int i = 0; i < 3; i++) {
                if (soundURL[i] == null) {
                    throw new Exception("Failed to load sound file at index " + i);
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading sound files: " + e.getMessage());
        }
    }

    public void setFile(int i) {
        if (i < 0 || i >= soundURL.length || soundURL[i] == null) {
            System.err.println("Invalid sound index: " + i);
            return;
        }

        try {
            if (clip != null && clip.isOpen()) {
                clip.stop();
                clip.close();
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            System.err.println("Error loading clip: ");
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
