package src.main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.buttons.ExitButton;
import src.buttons.StartButton;

public class MainMenu extends JPanel {

    // Key handler for capturing user input (if needed)
    KeyHandler keyH = new KeyHandler();

    // Static instance of the Sound class to handle menu music
    public static Sound music = new Sound();

    /**
     * Constructor for the MainMenu panel.
     * This sets up the menu layout, background, buttons, and starts the menu music.
     */
    public MainMenu() {
        // Disable layout manager to manually position components
        this.setLayout(null);

        // Start playing background music for the menu
        music.setFile(1);
        music.play();
        music.loop();
        
        // Create a JLabel to hold the background GIF
        JLabel backgroundLabel = new JLabel();
        ImageIcon backgroundGif;

        // Load the background GIF image from the resources folder
        backgroundGif = new ImageIcon(getClass().getResource("/src/res/ui/bkgif.gif"));
        backgroundLabel.setIcon(backgroundGif);
        backgroundLabel.setBounds(0, 0, backgroundGif.getIconWidth(), backgroundGif.getIconHeight());

        // Store the dimensions of the background image
        final int background_width = backgroundGif.getIconWidth();
        final int background_height = backgroundGif.getIconHeight();

        // Create a JLabel to act as a container for buttons
        JLabel buttonHolder = new JLabel();
        buttonHolder.setBounds(background_width / 4, 0, background_width / 2, background_height);
        buttonHolder.setOpaque(false); // Make the button holder transparent
        buttonHolder.setBackground(Color.BLUE); // Background color (not visible because opacity is off)

        // Create the start button with its label, color, and position
        StartButton startButton = new StartButton("Start Game", "1,50,150", false, 50, 410, 253, 50);
        
        // Create the exit button with its label, color, and position
        ExitButton exitButton = new ExitButton("Exit Game", "1,50,150", false, 50, 500, 253, 50);

        // Add buttons to the button holder
        buttonHolder.add(startButton);
        buttonHolder.add(exitButton);
        
        // Add background GIF to the panel
        this.add(backgroundLabel);
        
        // Add the button holder on top of the background
        this.add(buttonHolder);
        
        // Configure the menu panel properties
        this.setPreferredSize(new Dimension(background_width, background_height)); // Set panel size to match background
        this.setBackground(Color.BLACK); // Set background color (will be mostly hidden by the background GIF)
        this.setDoubleBuffered(true); // Improve rendering performance
        this.setComponentZOrder(buttonHolder, 0); // Ensure button holder stays above the background
        this.setFocusable(true); // Allow panel to capture key events
    }

    /**
     * Starts playing the menu background music.
     */
    public void playMenuMusic() {
        music.setFile(1);
        music.play();
        music.loop();
    }

    /**
     * Stops the menu background music.
     */
    public void stopMenuMusic() {
        music.stop();
    }
}
