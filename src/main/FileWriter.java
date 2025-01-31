package src.main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {
    public void writeFile() {

        try {

            // CREATE THE FILE
            File mapFile = new File("Map.txt");
            PrintWriter writer = new PrintWriter(mapFile);
            
            for(int i = 0; i < 50; i++) {
                writer.write(String.valueOf(i) + " \n");
                for(int j = 0; j < 50; j++) {
                    writer.write(String.valueOf(j) + " ");
                }
            }
                
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}