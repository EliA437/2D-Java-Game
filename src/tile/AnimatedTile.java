package src.tile;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import src.main.GamePanel;

public class AnimatedTile extends Tile {

    GamePanel gp;
    Tile[] tile;

    public AnimatedTile(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];

        getTileImage();
    }

    public void updateTile() {
        tileCounter++;
            if (tileCounter > 30) { // change this to make faster or slower
                if (tileNumber == 1) {
                    tileNumber = 2;
                } else if (tileNumber == 2) {
                    tileNumber = 1;
                }
                tileCounter = 0;
            }
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
            
        if(tileNumber == 1) {
            g2.drawImage(tile[1].image, 48, 48, gp.tileSize, gp.tileSize, null);
            
        } if(tileNumber == 2) {
            g2.drawImage(tile[2].image, 48, 48, gp.tileSize, gp.tileSize, null);
            
        }
        
        
        /*g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 0, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[3].image, 0, 48, gp.tileSize, gp.tileSize, null);*/

    }
}
