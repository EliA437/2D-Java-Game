package src.tile;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

import src.main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/src/res/maps/tilemap.txt"); // normal map
        //loadMap("/random_map.txt"); // random map
    }

    // load images here

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/grass/base_grass.png")); // base_grass:  // 0
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/grass/base_grass.png")); // grass_2:  // 1 // change later to a different grass variabt
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/grass/grass_3.png")); // grass_3:  // 2
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/grass/grass_4.png")); // grass_4:  // 3
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/src/res/tiles/naturals/bush_1.png")); // bush_1: // 4

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // loads the text file for map into a 2D array

    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            if (is == null) { // Check if the file was found
                throw new FileNotFoundException("Error: tilemap.txt not found!");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String[] numbers = line.split(" "); // split by spaces

                    if (numbers.length < gp.maxWorldCol) {
                        throw new IllegalArgumentException(
                                "Error: Insufficient numbers in line. Expected: " + gp.maxWorldCol + ", Found: "
                                        + numbers.length);
                    }

                    int num = Integer.parseInt(numbers[col]); // converts string into an integer
                    mapTileNum[col][row] = num; // store in map array
                    col++;
                }
                col = 0;
                row++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage()); // Print specific error message for missing file
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for other errors
        }
    }

    // iterates through 2D array and draws it

    public void draw(Graphics g2) {

        for (int worldRow = 0; worldRow < gp.maxWorldRow; worldRow++) {
            for (int worldCol = 0; worldCol < gp.maxWorldCol; worldCol++) {
                int tileNum = mapTileNum[worldCol][worldRow];

                int worldX = worldCol * gp.tileSize;
                int worldY = worldRow * gp.tileSize;
                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;

                if (screenX + gp.tileSize > 0 && screenX < gp.screenWidth &&
                        screenY + gp.tileSize > 0 && screenY < gp.screenHeight) {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            }
        }
    }
}
