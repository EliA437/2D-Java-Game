package src.main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String args[]) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Java Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); // Sizes the window to fit the GamePanel
        window.setLocationRelativeTo(null); // Centers the window on the screen
        window.setVisible(true);
        // Delay before requesting focus, if necessary
        SwingUtilities.invokeLater(() -> gamePanel.requestFocusInWindow());


        // Request focus after the window is visible
        gamePanel.requestFocusInWindow(); // Ensures that the panel is focused to capture key events

        gamePanel.startGameThread();
    }
}
