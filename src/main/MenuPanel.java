package src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.setFocusable(true);
        
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(GamePanel.screenWidth / 2, 150, 200, 50); // Centered
        
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
        playMusic(1);   // Play title card music after adding the button
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE); 
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("2D Java Game", GamePanel.screenWidth / 2, 150); // Draw text at (x, y)
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
