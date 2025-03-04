package src.main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {    

    static JFrame window;
    public static void main(String args[]) { 

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeFile(); 
        fileWriter.writeRandomFile();  
        KeyHandler keyHandler = new KeyHandler();

        // setup JFrame
        window = new JFrame(); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setUndecorated(true);
        MenuPanel menuPanel = new MenuPanel();
        window.add(menuPanel);
        window.pack(); // makes window fit preffered size of GamePanel
        window.setLocationRelativeTo(null); // center the window on the screen
        window.setVisible(true);
        window.addKeyListener(keyHandler);
    }

    public static void startGame() {

        window.getContentPane().removeAll(); // remove menu panel

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); 
        window.setLocationRelativeTo(null); 
        window.setVisible(true);

        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());  // Ensures the game panel gets focus, allowing it to capture key events (keyboard inputs)
        gamePanel.startGameThread(); // Start the game loop in GamePanel (likely a separate thread for updating the game)
    }

    public static void opengGameMenu() {

        window.getContentPane().removeAll();

        GameMenu gameMenu = new GameMenu();
        window.add(gameMenu);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        SwingUtilities.invokeLater(() -> gameMenu.requestFocusInWindow());  // Ensures the game panel gets focus, allowing it to capture key events (keyboard inputs)
    }

    public static void exitGame() {
        window.dispose();
        System.exit(0);
    }
}


