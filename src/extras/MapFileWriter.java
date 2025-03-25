package src.extras;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MapFileWriter {
    
    public void writeFile() {

        final int ROW_NUM = 500;

        try {

            // CREATE THE FILE
            File mapFile = new File("map.txt");
            PrintWriter writer = new PrintWriter(mapFile);
            
            int j = 1;
            for(int i = 0; i < ROW_NUM * ROW_NUM; i++) {

                if(j % ROW_NUM == 0) {
                    writer.write(String.valueOf(j) + " \n");
                    j = 1;
                }
                
                else {
                    writer.write(String.valueOf(j) + " ");
                    j++;
                }
                
            }
                
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRandomFile() {

        // change these setting to produce different results
        final int ROW_NUM = 500;
        final int MAX_TILE_NUMBER = 5;

        try {

            // CREATE THE FILE
            File mapFile = new File("random_map.txt");
            PrintWriter writer = new PrintWriter(mapFile);
            
            Random random = new Random();
            int j = 1;

            for(int i = 0; i < ROW_NUM * ROW_NUM; i++) {

                if(j % ROW_NUM == 0) {
                    writer.write(String.valueOf(random.nextInt(MAX_TILE_NUMBER)) + " \n");
                    j = 1;
                }
                
                else {
                    writer.write(String.valueOf(random.nextInt(MAX_TILE_NUMBER)) + " ");
                    j++;
                }
                
            }
                
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}