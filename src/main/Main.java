package src.main;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import src.extras.MapFileWriter;

public class Main {    

    // Main application window
    static JFrame window;

    // CardLayout for switching between different panels (menus, game, etc.)
    static CardLayout cardLayout;
    static JPanel mainPanel;

    // Panels for different game screens
    static GamePanel gamePanel = new GamePanel();
    static GameMenu gameMenu = new GameMenu();
    static MainMenu mainMenu = new MainMenu();

    // Flag to track if game music has started
    static boolean musicStarted = false;

    public static void main(String args[]) { 
    
        // Create a MapFileWriter and generate a random map file
        MapFileWriter fileWriter = new MapFileWriter();
        fileWriter.writeRandomFile();

        // Initialize key handler for capturing user input
        KeyHandler keyHandler = new KeyHandler();

        // Setup the main application window
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the program when window is closed
        window.setResizable(false);  // Prevent resizing the window
        window.setUndecorated(true); // Remove default window decorations
        window.addKeyListener(keyHandler); // Attach key listener for input handling

        // Initialize CardLayout to manage different screens
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        window.setContentPane(mainPanel); // Set the main panel as content

        // Add different panels to the CardLayout
        mainPanel.add(mainMenu, "Menu");      // Main menu panel
        mainPanel.add(gamePanel, "Game");     // Main game panel
        mainPanel.add(gameMenu, "GameMenu");  // In-game menu panel

        // Show the main menu by default
        cardLayout.show(mainPanel, "Menu");

        // Start playing the menu music
        mainMenu.playMenuMusic();

        // Finalize window settings
        window.pack(); 
        window.setSize(GamePanel.screenWidth, GamePanel.screenHeight); // Set window size
        window.setLocationRelativeTo(null); // Center the window on screen
        window.setVisible(true); // Display the window
    }

    /**
     * Starts the game, stops menu music, and begins game music if not started.
     * Also switches the view to the GamePanel.
     */
    public static void startGame() {
        mainMenu.stopMenuMusic(); // Stop menu music when game starts

        // Ensure game music starts only once
        if (!musicStarted) {
            gamePanel.playGameMusic();
            musicStarted = true;
        }

        // Switch to the game panel
        cardLayout.show(mainPanel, "Game");

        // Request focus for key inputs and start game loop
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());
        gamePanel.startGameThread();
    }

    /**
     * Exits the game by closing the window and terminating the application.
     */
    public static void exitGame() {
        window.dispose(); // Close the window
        System.exit(0);   // Terminate the program
    }

    /**
     * Opens the in-game menu.
     */
    public static void openGameMenu() {
        cardLayout.show(mainPanel, "GameMenu"); // Switch to game menu panel
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow()); // Maintain input focus
    }

    /**
     * Closes the in-game menu and resumes the game.
     */
    public static void closeGameMenu() {
        startGame(); // Resume the game by switching back to GamePanel
    }
}
