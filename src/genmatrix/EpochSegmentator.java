package genmatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EpochSegmentator extends EGGFileManager {
    
    private String output1 = "epoch1.csv";
    private String output2 = "epoch2.csv";
    private String output3 = "epoch3.csv";

    private String input = "p300.csv";
    
    public void segment() {
        
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        BufferedWriter writer1 = null;
        BufferedWriter writer2 = null;
        BufferedWriter writer3 = null;
        
        try {
            long startTime = System.currentTimeMillis();
            
            System.out.println("Segmentation started.");
    
            reader1 = new BufferedReader(new FileReader(input));
            reader2 = new BufferedReader(new FileReader(outputFilename));
            
            writer1 = new BufferedWriter(new FileWriter(getCurrentDirectory() +
                    pathSeparator + output1));
            
            writer2 = new BufferedWriter(new FileWriter(getCurrentDirectory() +
                    pathSeparator + output2));
            
            writer3 = new BufferedWriter(new FileWriter(getCurrentDirectory() +
                    pathSeparator + output3));
            
            int totalEpoch1 = 0;
            int totalEpoch2 = 0;
            int totalEpoch3 = 0;
            
            for (int i = 0; i < numberOfEpochs; i++) {
                String line = reader1.readLine();
                String[] elements = line.split( "" + elementSeparator);
                int last = elements.length - 1;
                String element = elements[last];
                int start = i * numberOfSamplesPerEpoch;

                if (element.equals("1")) {
                    totalEpoch1++;
                    for (int j = start; j < start + numberOfSamplesPerEpoch ; j++) {
                        String subline = reader2.readLine();
                        if (subline != null) {
                            writer1.write(subline);
                            writer1.newLine();
                        } else {
                            System.out.println("Null index j = " + j);
                        }
                    }
                    
                } else if (element.equals("2")) {
                    totalEpoch2++;
                    for (int k = start; k < start + numberOfSamplesPerEpoch; k++) {
                        String subline = reader2.readLine();
                        if (subline != null) {
                            writer2.write(subline);
                            writer2.newLine();
                        } else {
                            System.out.println("Null index k = " + k);
                        }
                    }
                    
                } else if (element.equals("3")) {
                    totalEpoch3++;
                    for (int l = start; l < start + numberOfSamplesPerEpoch; l++) {
                        String subline = reader2.readLine();
                        if (subline != null) {
                            writer3.write(subline);
                            writer3.newLine();
                        } else {
                            System.out.println("Null index l = " + l);
                        }
                    }
                }
            }
            
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            
            System.out.println("Segmentation finished in: " + totalTime + " milliseconds.");
            System.out.println("Stats: ");
            
            System.out.println("Total epoch1 = " + totalEpoch1);
            System.out.println("Total epoch2 = " + totalEpoch2);
            System.out.println("Total epoch3 = " + totalEpoch3);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EpochSegmentator.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException io) {
            Logger.getLogger(EpochSegmentator.class.getName())
                    .log(Level.SEVERE, null, io);
        } finally {
            try {
                reader1.close();
                reader2.close();
                
                writer1.close();
                writer2.close();
                writer3.close();
            } catch (IOException ex) {
                Logger.getLogger(EpochSegmentator.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
