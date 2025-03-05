package src.main;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.buttons.ExitButton;
import src.buttons.StartButton;


public class MainMenu extends JPanel {

    KeyHandler keyH = new KeyHandler();
    public static Sound music = new Sound();

    public MainMenu() {

        this.setLayout(null);

        // start music
        music.setFile(1);
        music.play();
        music.loop();
        
        // setup background gif
        JLabel backgroundLabel = new JLabel();
        ImageIcon backgroundGif;

        backgroundGif = new ImageIcon(getClass().getResource("/src/res/ui/bkgif.gif"));
        backgroundLabel.setIcon(backgroundGif);
        backgroundLabel.setBounds(0, 0, backgroundGif.getIconWidth(), backgroundGif.getIconHeight());

        final int background_width = backgroundGif.getIconWidth();
        final int background_height = backgroundGif.getIconHeight();

        // setup button holder
        JLabel buttonHolder = new JLabel();
        buttonHolder.setBounds(background_width / 4, 0, background_width / 2, background_height);
        buttonHolder.setOpaque(false); // determines if its visible
        buttonHolder.setBackground(Color.BLUE);
        //System.out.println("width " + buttonHolder.getWidth());
        //System.out.println("height " + buttonHolder.getHeight());
        
        // setup start button
        StartButton startButton = new StartButton("Start Game", "1,50,150", false, 50, 410, 253, 50);
        // setup exit button
        ExitButton exitButton = new ExitButton("Exit Game", "1,50,150", false, 50, 500, 253, 50);

        // add start button to button holder
        buttonHolder.add(startButton);
        // add exit button to button holder
        buttonHolder.add(exitButton);
        
        // add background gif
        this.add(backgroundLabel);
        // add button holder
        this.add(buttonHolder);
        
        // setup menu panel
        this.setPreferredSize(new Dimension(background_width, background_height)); 
        this.setBackground(Color.BLACK); 
        this.setDoubleBuffered(true);
        this.setComponentZOrder(buttonHolder, 0);   // force correct Z-order: move `buttonHolder` above `backgroundLabel`
        this.setFocusable(true);


    }

    public void playMenuMusic() {
        music.setFile(1);
        music.play();
        music.loop();
    }

    public void stopMenuMusic() {
        music.stop();
    }
  
}
