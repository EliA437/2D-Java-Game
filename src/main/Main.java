package src.main;

import javax.swing.JFrame; 
import javax.swing.SwingUtilities;

public class Main {    
    public static void main(String args[]) { 

        JFrame window = new JFrame(); 
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeFile();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Java Game");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // Automatically sizes the window to fit the preferred size of GamePanel
        window.setLocationRelativeTo(null); // Center the window on the screen
        window.setVisible(true);
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());  // Ensures the game panel gets focus, allowing it to capture key events (keyboard inputs)
        gamePanel.startGameThread(); // Start the game loop in GamePanel (likely a separate thread for updating the game)
    }
}
