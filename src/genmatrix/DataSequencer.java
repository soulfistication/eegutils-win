package genmatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSequencer extends FileManager {
    
    private String output1 = "output1.csv";
    private String output2 = "output2.csv";
    private String output3 = "output3.csv";

    private String input = "p300.csv";
    
    public void open() {
        
        BufferedReader reader = null;
        BufferedWriter writer1 = null;
        BufferedWriter writer2 = null;
        
        int[] firstEpochIndices = new int[300];
        int[] secondEpochIndices = new int[300];
        int[] thirdEpochIndices = new int[300];
        
        try {
    
            reader = new BufferedReader(new FileReader(input));
            
            for (int i = 0; i < 300; i++) {
                String line = reader.readLine();
                String[] elements = line.split( "" + elementSeparator);
                int last = elements.length - 1;
                String element = elements[last];
                
                if (element.equals("1")) {
                    firstEpochIndices[i] = 1;
                } else if (element.equals("2")) {
                    secondEpochIndices[i] = 2;
                } else if (element.equals("3")) {
                    thirdEpochIndices[i] = 3;
                }
            }
            
            for(int i = 0; i < firstEpochIndices.length; i++) {
                System.out.println("Index = " + i + " Value = " + firstEpochIndices[i]);
            }
            
            for(int i = 0; i < secondEpochIndices.length; i++) {
                System.out.println("Index = " + i + " Value = " + secondEpochIndices[i]);
            }
            
            writer1 = new BufferedWriter(new FileWriter(getCurrentDirectory() +
                    pathSeparator + output1));
            
            writer2 = new BufferedWriter(new FileWriter(getCurrentDirectory() +
                    pathSeparator + output2));
    
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataSequencer.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException io) {
            Logger.getLogger(DataSequencer.class.getName())
                    .log(Level.SEVERE, null, io);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(DataSequencer.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
