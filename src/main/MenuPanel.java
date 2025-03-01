package src.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();

    public MenuPanel() {

        this.requestFocus();
        
        // add background gif
        JLabel backgroundLabel = new JLabel();
        try {
            ImageIcon backgroundGif= new ImageIcon(getClass().getResource("/src/res/misc/background_gif.gif"));
            backgroundLabel.setIcon(backgroundGif);
            backgroundLabel.setBounds(0, 0, backgroundGif.getIconWidth(), backgroundGif.getIconHeight());
            this.setPreferredSize(new Dimension(backgroundGif.getIconWidth(), backgroundGif.getIconHeight()));
            this.add(backgroundLabel);
        } catch(Exception e) {
            System.out.println("Error loading background GIF: " + e.getMessage());
        }

        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); 
        this.addKeyListener(keyH);
        this.setFocusable(true);

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(GamePanel.screenWidth / 2, 150, 200, 50); // Centered
        
        // add action listener to handle button clicks
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                stopMusic();
                Main.startGame();
            }
        });

        this.add(startButton);
        playMusic(1);   // play title card music
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE); 
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("sunday", GamePanel.screenWidth / 2, GamePanel.screenHeight / 2); 
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
