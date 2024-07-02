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
public class MatrixGenerator extends EEGFileManager {

    public MatrixGenerator(ParadigmType type) {
        super(type);
    }
    
    public void generate() {
        System.out.println("Matrix generation started.");
        long start = System.currentTimeMillis();
        
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        BufferedReader reader3 = null;
        BufferedReader reader4 = null;
        BufferedReader reader5 = null;
        BufferedReader reader6 = null;
        BufferedReader reader7 = null;
        BufferedReader reader8 = null;
        BufferedReader reader9 = null;
        BufferedReader reader10 = null;
        BufferedReader reader11 = null;
        BufferedReader reader12 = null;
        BufferedReader reader13 = null;
        BufferedReader reader14 = null;
        BufferedReader reader15 = null;
        BufferedReader reader16 = null;
        
        BufferedWriter writer = null;
        
        try {
            reader1 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset1[0]));
            reader2 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset1[1]));
            reader3 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset1[2]));
            reader4 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset1[3]));
            reader5 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset1[4]));
            reader6 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset1[5]));
            reader7 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset1[6]));
            reader8 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset1[7]));
            reader9 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset2[0]));
            reader10 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset2[1]));
            reader11 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset2[2]));
            reader12 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset2[3]));
            reader13 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset2[4]));
            reader14 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset2[5]));
            reader15 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset2[6]));
            reader16 = new BufferedReader(new FileReader(getCurrentDirectory() + pathSeparator + dataset2[7]));
            
            writer = new BufferedWriter(new FileWriter(getCurrentDirectory() + pathSeparator + getOutputFilename()));
            
            for (int i = 0; i < numberOfLines; i++) {
                String line1 = reader1.readLine();
                String line2 = reader2.readLine();
                String line3 = reader3.readLine();
                String line4 = reader4.readLine();
                String line5 = reader5.readLine();
                String line6 = reader6.readLine();
                String line7 = reader7.readLine();
                String line8 = reader8.readLine();
                String line9 = reader9.readLine();
                String line10 = reader10.readLine();
                String line11 = reader11.readLine();
                String line12 = reader12.readLine();
                String line13 = reader13.readLine();
                String line14 = reader14.readLine();
                String line15 = reader15.readLine();
                String line16 = reader16.readLine();
                
                writer.write(
                    "" + 
                    convert(line1) + elementSeparator +
                    convert(line2) + elementSeparator +
                    convert(line3) + elementSeparator +
                    convert(line4) + elementSeparator +
                    convert(line5) + elementSeparator +
                    convert(line6) + elementSeparator +
                    convert(line7) + elementSeparator +
                    convert(line8) + elementSeparator +
                    convert(line9) + elementSeparator +
                    convert(line10) + elementSeparator +
                    convert(line11) + elementSeparator +
                    convert(line12) + elementSeparator +
                    convert(line13) + elementSeparator +
                    convert(line14) + elementSeparator +
                    convert(line15) + elementSeparator +
                    convert(line16)
                );
                
                writer.newLine();
            }
            
        } catch (FileNotFoundException fnfe) {
            Logger.getLogger(MatrixGenerator.class.getName()).log(Level.SEVERE, "File not found on Matrix Generator", fnfe);
        } catch (IOException ioe) {
            Logger.getLogger(MatrixGenerator.class.getName()).log(Level.SEVERE, "I/O Exception on Matrix Generator", ioe);
        } finally {
            
            try {
                if (reader1 != null) {
                    reader1.close();
                }
                if (reader2 != null) {
                    reader2.close();
                }
                if (reader3 != null) {
                    reader3.close();
                }
                if (reader4 != null) {
                    reader4.close();
                }
                if (reader5 != null) {
                    reader5.close();
                }
                if (reader6 != null) {
                    reader6.close();
                }
                if (reader7 != null) {
                    reader7.close();
                }
                if (reader8 != null) {
                    reader8.close();
                }
                if (reader9 != null) {
                    reader9.close();
                }
                if (reader10 != null) {
                    reader10.close();
                }
                if (reader11 != null) {
                    reader11.close();
                }
                if (reader12 != null) {
                    reader12.close();
                }
                if (reader13 != null) {
                    reader13.close();
                }
                if (reader14 != null) {
                    reader14.close();
                }
                if (reader15 != null) {
                    reader15.close();
                }
                if (reader16 != null) {
                    reader16.close();
                }
                if (writer != null) {
                    writer.close();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(MatrixGenerator.class.getName()).log(Level.WARNING, "Error while closing streams", ex);
            }
        }
        
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("Matrix Generation finished in " + result + " milliseconds.");
    }
    
    private double convert(String pointString) {
        double error = -999999999.99;
        if (pointString == null) {
            return error;
        }
        try {
            int point = Integer.parseInt(pointString);
            return ((point - 2048) / 25.0);
        } catch (NumberFormatException nfe) {
            Logger.getLogger(MatrixGenerator.class.getName()).log(Level.SEVERE, "Error reading line: " + pointString + " is not a valid integer value", nfe);
        }
        return error;
    }
}
