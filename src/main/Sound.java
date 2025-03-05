package src.main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/src/res/sound/your_face.wav"); 
        soundURL[1] = getClass().getResource("/src/res/sound/pretty_poison_loading_music.wav"); // menu music
        soundURL[2] = getClass().getResource("/src/res/sound/gameplaymusic_1.wav"); // first soundtrack
    }

    public void setFile(int i) {
        if (clip != null && clip.isOpen()) {
            clip.stop();
            clip.flush();
            clip.close();
        }
        try {   
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        clip.flush();
        clip.close();
    }
}
