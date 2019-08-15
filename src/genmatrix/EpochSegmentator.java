/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genmatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan Almada
 */

public class EpochSegmentator extends EEGFileManager {

    public EpochSegmentator(ParadigmType type) {
        super(type);
    }
    
    protected String getOutput1() {
        switch (type) {
            case P1:
                return "";
            case EG:
                return "";
            case P3:
                return "P3INFR.ASC";
            case N4:
                return "N4CONGR.ASC";
            case EM:
                return "EMENOJO.ASC";
            default:
                return "";
        }
    }
    
    protected String getOutput2() {
        switch (type) {
            case P1:
                return "";
            case EG:
                return "";
            case P3:
                return "P3FREC.ASC";
            case N4:
                return "N4INCONGR.ASC";
            case EM:
                return "EMFELIZ.ASC";
            default:
                return "";
        }
    }
    
    protected String getOutput3() {
        switch (type) {
            case P1:
                return "";
            case EG:
                return "";
            case P3:
                return "";
            case N4:
                return "";
            case EM:
                return "EMNEUTRO.ASC";
            default:
                return "";
        }
    }
    
    private final String elementSegmentatorSeparator = ",";
    
    private final String input = getParadigmTypePrefix() + ".csv";
    
    public void segment() {
        
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        
        BufferedWriter writer1 = null;
        BufferedWriter writer2 = null;
        BufferedWriter writer3 = null;
        
        try {
            // Configure the writers depending on the paradigm type.
            switch (type) {
                case P1:
                    return; // Output should be Epochall.asc nothing to segment
                case EG:
                    return; // Output should be Epochall.asc nothing to segment
                case P3:
                    writer1 = new BufferedWriter(
                            new FileWriter(getCurrentDirectory() + pathSeparator + getOutput1())
                            );
                    writer2 = new BufferedWriter(
                            new FileWriter(getCurrentDirectory() + pathSeparator + getOutput2())
                            );
                    writer3 = null;
                    break;
                case N4:
                    writer1 = new BufferedWriter(
                            new FileWriter(getCurrentDirectory() + pathSeparator + getOutput1())
                            );
                    writer2 = new BufferedWriter(
                            new FileWriter(getCurrentDirectory() + pathSeparator + getOutput2())
                            );
                    writer3 = null;
                    break;
                case EM:
                    writer1 = new BufferedWriter(
                            new FileWriter(getCurrentDirectory() + pathSeparator + getOutput1())
                            );
                    writer2 = new BufferedWriter(
                            new FileWriter(getCurrentDirectory() + pathSeparator + getOutput2())
                            );
                    writer3 = new BufferedWriter(
                            new FileWriter(getCurrentDirectory() + pathSeparator + getOutput3())
                            );
                    break;
                default:
                    return;
            }
            
            long startTime = System.currentTimeMillis();
            
            System.out.println("Segmentation started.");
            
            reader1 = new BufferedReader(new FileReader(input));
            reader2 = new BufferedReader(new FileReader(getOutputFilename()));
            
            int totalEpoch1 = 0;
            int totalEpoch2 = 0;
            int totalEpoch3 = 0;
            
            for (int i = 0; i < getNumberOfEpochs(); i++) {
                String line = reader1.readLine();
                String[] elements = line.split("" + elementSegmentatorSeparator);
                int last = elements.length - 1;
                String element = elements[last];
                int start = i * getNumberOfSamplesPerEpoch();
                
                if (element.equals("1")) {
                    totalEpoch1++;
                    for (int j = start; j < start + getNumberOfSamplesPerEpoch(); j++) {
                        String subline = reader2.readLine();
                        if (subline != null) {
                            writer1.write(subline);
                            writer1.newLine();
                        } else {
                            System.out.println("Null index j = " + j);
                        }
                    }
                }
                else if (element.equals("2")) {
                    totalEpoch2++;
                    for (int k = start; k < start + getNumberOfSamplesPerEpoch(); k++) {
                        String subline = reader2.readLine();
                        if (subline != null) {
                            writer2.write(subline);
                            writer2.newLine();
                        } else {
                            System.out.println("Null index k = " + k);
                        }
                    }
                }
                else if (element.equals("3")) {
                    totalEpoch3++;
                    for (int l = start; l < start + getNumberOfSamplesPerEpoch(); l++) {
                        String subline = reader2.readLine();
                        if (subline != null && writer3 != null) {
                            writer3.write(subline);
                            writer3.newLine();
                        } else {
                            System.out.println("Null index l = " + l);
                        }
                    }
                }
                
                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                
                System.out.println("Segmentation finished in " + totalTime + " milliseconds.");
                System.out.println("Stats: ");
                
                System.out.println("Total epoch1 = " + totalEpoch1);
                System.out.println("Total epoch2 = " + totalEpoch2);
                System.out.println("Total epoch3 = " + totalEpoch3);
                
            }
        } catch (FileNotFoundException fnfe) {
            Logger.getLogger(EpochSegmentator.class.getName()).log(Level.SEVERE, "Error segmenting file not found", fnfe);
        } catch (IOException ioex) {
            Logger.getLogger(EpochSegmentator.class.getName()).log(Level.SEVERE, "I/O Error while segmenting file", ioex);
        } finally {
            try {
                if (reader1 != null) {
                    reader1.close();
                }
                if (reader2 != null) {
                    reader2.close();
                }
                if (writer1 != null) {
                    writer1.close();
                }
                if (writer2 != null) {
                    writer2.close();
                }
                if (writer3 != null) {
                    writer3.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(EpochSegmentator.class.getName()).log(Level.SEVERE, "I/O Error while closing file", ex);
            }
        }
    }
}
