package src.main;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {    

    static JFrame window;
    static CardLayout cardLayout;
    static JPanel mainPanel;
    static GamePanel gamePanel = new GamePanel();;
    static GameMenu gameMenu = new GameMenu();
    static MainMenu mainMenu = new MainMenu();
    static boolean musicStarted = false;
    
    public static void main(String args[]) { 

        KeyHandler keyHandler = new KeyHandler();

        // setup JFrame
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setUndecorated(true);
        window.addKeyListener(keyHandler);

        // setup CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        window.setContentPane(mainPanel);

        // add panels to CardLayout
        mainPanel.add(mainMenu, "Menu");
        mainPanel.add(gamePanel, "Game");
        mainPanel.add(gameMenu, "GameMenu");

        // show menu first
        cardLayout.show(mainPanel, "Menu");

        mainMenu.playMenuMusic();
        window.pack(); 
        window.setSize(GamePanel.screenWidth, GamePanel.screenHeight);
        window.setLocationRelativeTo(null); 
        window.setVisible(true);
    }

    public static void startGame() {
        mainMenu.stopMenuMusic();
        if(musicStarted == false) {
            gamePanel.playGameMusic();
            musicStarted = true;
        }
        cardLayout.show(mainPanel, "Game");
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());  
        gamePanel.startGameThread();
    }

    public static void exitGame() {
        window.dispose();
        System.exit(0);
    }

    public static void openGameMenu() {
        cardLayout.show(mainPanel, "GameMenu");
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());
    }

    public static void closeGameMenu() {
        startGame();
    }
}
