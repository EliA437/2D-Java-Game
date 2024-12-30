import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
     
    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // FPS
    int fps = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    // CONSTRUCTOR
    public GamePanel() {
        System.out.println("Panel focused: " + this.hasFocus()); // Initial focus check
        this.requestFocus();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // Improve rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);

        // Add FocusListener to debug focus issues
    this.addFocusListener((FocusListener) new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("GamePanel has focus.");
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("GamePanel lost focus.");
        }
    });
        
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps; // 0.01666666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            //System.out.println("Game loop running..."); //

            update();  // Update player position

            repaint(); // Trigger the repaint

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000; // convert to milliseconds
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void update() {
        //System.out.println("Update method called");  
    
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
            System.out.println("Up pressed: playerY = " + playerY);
        }
        if (keyH.downPressed == true) {
            playerY += playerSpeed;
            System.out.println("Down pressed: playerY = " + playerY);
        }
        if (keyH.rightPressed == true) {
            playerX += playerSpeed;
            System.out.println("Right pressed: playerX = " + playerX);
        }
        if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
            System.out.println("Left pressed: playerX = " + playerX);
        }
    }
    
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize); // Drawing player
        
        // Debugging output for player position
        //System.out.println("Player position in paint: (" + playerX + ", " + playerY + ")");
        
        g2.dispose();
    }

}
