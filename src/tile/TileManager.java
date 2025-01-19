package src.tile;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import src.main.GamePanel;

public class TileManager{
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];

        getTileImage();
    }

    // import tile images
    
    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/grass.png")); // grass 0

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/wall.png")); // wall 1

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/earth.png")); // earth 2

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/tree.png")); // tree 3

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    

    public void draw(Graphics g2) {
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 0, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[3].image, 0, 48, gp.tileSize, gp.tileSize, null);
    }
}
