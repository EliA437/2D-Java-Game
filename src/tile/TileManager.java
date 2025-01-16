package src.tile;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import src.main.GamePanel;

public class TileManager extends Tile{
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

    public void draw(Graphics g2) {

        Random random = new Random();
        
        
        // draw grass background
        for(int j = 0; j < 768; j += 48) {
            
            // used to create tile animation
            for(int i = 0; i < 673; i += 48) {

                if(j == 0 || i == 0 || j == 720 || i == 529) {
                    g2.drawImage(tile[1].image, j, i, gp.tileSize, gp.tileSize, null);
                }
                
                else if(j == 48 && i == 48) {

                    if(tileNumber == 1) {
                        g2.drawImage(tile[1].image, j, i, gp.tileSize, gp.tileSize, null);
                        System.out.println("grass");
                    } if(tileNumber == 2) {
                        g2.drawImage(tile[2].image, j, i, gp.tileSize, gp.tileSize, null);
                        System.out.println("stone");
                    }
                }

                else {
                    
                        g2.drawImage(tile[0].image, j, i, gp.tileSize, gp.tileSize, null);
            
                }
            
            }
          
        }
        
        
        /*g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, 0, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[3].image, 0, 48, gp.tileSize, gp.tileSize, null);*/

    }
}
