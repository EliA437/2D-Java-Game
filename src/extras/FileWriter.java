package src.extras;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileWriter {
    
    public void writeFile() {

        final int ROW_NUM = 50;

        try {

            // CREATE THE FILE
            File mapFile = new File("map.txt");
            PrintWriter writer = new PrintWriter(mapFile);
            
            int j = 1;
            for(int i = 0; i < ROW_NUM * ROW_NUM; i++) {

                if(j % 50 == 0) {
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

        final int ROW_NUM = 50;

        try {

            // CREATE THE FILE
            File mapFile = new File("random_map.txt");
            PrintWriter writer = new PrintWriter(mapFile);
            
            Random random = new Random();
            int j = 1;

            for(int i = 0; i < ROW_NUM * ROW_NUM; i++) {

                if(j % 50 == 0) {
                    writer.write(String.valueOf(random.nextInt(5)) + " \n");
                    j = 1;
                }
                
                else {
                    writer.write(String.valueOf(random.nextInt(5)) + " ");
                    j++;
                }
                
            }
                
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}