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
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/flower_1.png")); // flower_1

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/flower_2.png")); // flower_2 


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void draw(Graphics g2) {
            
        if(tileNumber == 1) {
            g2.drawImage(tile[0].image, 96, 96, gp.tileSize, gp.tileSize, null);
            
        } if(tileNumber == 2) {
            g2.drawImage(tile[1].image, 96, 96, gp.tileSize, gp.tileSize, null);
            
        }
        
    }
}
