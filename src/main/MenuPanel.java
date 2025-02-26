package src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();

    public MenuPanel() {
        this.requestFocus();
        this.setPreferredSize(new Dimension(GamePanel.screenWidth, GamePanel.screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // Improve rendering performance
        this.addKeyListener(keyH);
        playMusic(1);   // play title card music
        
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(GamePanel.screenWidth / 2 - 100, GamePanel.screenHeight / 2, 200, 50); // Centered
        
        // Add an action listener to handle button clicks
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Here, you can switch to the GamePanel
                stopMusic();
                Main.startGame();
            }
        });

        this.add(startButton); // Add button to panel
        this.setFocusable(true);
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }
}
