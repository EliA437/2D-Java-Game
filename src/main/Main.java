package src.main;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {    

    static JFrame window;
    static CardLayout cardLayout;
    static JPanel mainPanel;
    static GamePanel gamePanel;
    static GameMenu gameMenu;

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

        // create panels 
        MainMenu mainMenu = new MainMenu();
        gamePanel = new GamePanel();
        gameMenu = new GameMenu();

        // add panels to CardLayout
        mainPanel.add(mainMenu, "Menu");
        mainPanel.add(gamePanel, "Game");
        mainPanel.add(gameMenu, "GameMenu");

        // Show menu first
        cardLayout.show(mainPanel, "Menu");

        window.pack(); 
        window.setSize(GamePanel.screenWidth, GamePanel.screenHeight);
        window.setLocationRelativeTo(null); 
        window.setVisible(true);
    }

    public static void startGame() {
        cardLayout.show(mainPanel, "Game");
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());  
        gamePanel.startGameThread(); 
    }

    public static void openGameMenu() {
        cardLayout.show(mainPanel, "GameMenu");
        SwingUtilities.invokeLater(() -> gameMenu.requestFocusInWindow());
    }

    public static void exitGame() {
        window.dispose();
        System.exit(0);
    }
}
