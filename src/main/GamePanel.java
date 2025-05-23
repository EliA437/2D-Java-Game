package src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import src.entity.Player;
import src.tile.AnimatedTile;
import src.tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
     
    // SCREEN SETTINGS
    final static int originalTileSize = 16; // 16x16 tile
    final static int scale = 3;
    public final static int tileSize = originalTileSize * scale; // 48x48 tile
    public final static int maxScreenCol = 16; 
    public final static int maxScreenRow = 14; 
    public final static int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final static int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // WORLD SETTINGS
    public final int maxWorldCol = 50;  // adjust map width
    public final int maxWorldRow = 50;  // adjust map height
    public final int worldWidth = tileSize * maxScreenCol;
    public final int worldHeight = tileSize * maxScreenRow;

    // FPS
    int fps = 60;

    AnimatedTile animatedTile = new AnimatedTile(this);
    TileManager tile = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this,keyH);

    // Flags
    private boolean running = false;

    public static Sound music = new Sound();

    // CONSTRUCTOR
    public GamePanel() {
        this.requestFocus();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // Improve rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);  
    }
    
    public void startGameThread() {
        if(running) {
            return; // prevent multiple game threads from starting
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGameThread() {
        running = false;
        if(gameThread != null) {
            try {
                gameThread.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            gameThread = null;
        }
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps; // 0.01666666 seconds 1000000000
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                animatedTile.updateTile();
                repaint();
                delta--;
                drawCount++;
            } 

            if(timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
       player.update();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        tile.draw(g2);
        //animatedTile.draw(g2);
        player.draw(g2);
        g2.dispose();
        
    }

    public void playGameMusic() {
        music.setFile(2);
        music.play();
        music.loop();
    }

    public void stopGameMusic() {
        music.stop();
    }
}
