package genmatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatrixCreator extends FileManager {
    
    String[] dataset1 = {
        "EGF1.DAT", "EGF3.DAT", "EGC3.DAT", "EGP3.DAT",
        "EGO1.DAT", "EGF7.DAT", "EGT3.DAT", "EGT5.DAT"
    };
    
    String[] dataset2 = {
        "EGF2.DAT", "EGF4.DAT", "EGC4.DAT", "EGP4.DAT",
        "EGO2.DAT", "EGF8.DAT", "EGT4.DAT", "EGT6.DAT"
    };
    
    @Override
    public void listFilenames() {
        for (String filename : dataset1) {
            System.out.println(filename);
        }
        
        for (String filename : dataset2) {
            System.out.println(filename);
        }
    }
    
    public void generateMatrix() {
        
        long init = System.currentTimeMillis();

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
            reader1 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset1[0]));
            reader2 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset1[1]));
            reader3 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset1[2]));
            reader4 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset1[3]));
            reader5 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset1[4]));
            reader6 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset1[5]));
            reader7 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset1[6]));
            reader8 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset1[7]));
            reader9 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset2[0]));
            reader10 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset2[1]));
            reader11 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset2[2]));
            reader12 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset2[3]));
            reader13 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset2[4]));
            reader14 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset2[5]));
            reader15 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset2[6]));
            reader16 = new BufferedReader(new FileReader(getCurrentDirectory() +
                    pathSeparator + dataset2[7]));
            
            writer = new BufferedWriter(new FileWriter(getCurrentDirectory() +
                    pathSeparator + outputFilename));
            
            int numberOfLines = 76800;
            
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
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatrixCreator.class.getName())
                    .log(Level.WARNING, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatrixCreator.class.getName())
                    .log(Level.WARNING, null, ex);
        } finally {
            
            try {
                reader1.close();
                reader2.close();
                reader3.close();
                reader4.close();
                reader5.close();
                reader6.close();
                reader7.close();
                reader8.close();
                reader9.close();
                reader10.close();
                reader11.close();
                reader12.close();
                reader13.close();
                reader14.close();
                reader15.close();
                reader16.close();
            
                writer.close();
                
            } catch(IOException io) {
                
                Logger.getLogger(DataSequencer.class.getName())
                        .log(Level.SEVERE, null, io);
                
            }
            
        }
        
        long end = System.currentTimeMillis();
        long result = end - init;
        System.out.println("Execution time: " + result + " milliseconds.");
    }

    private double convert(String pointString) {
        int point = Integer.parseInt(pointString);
        return ((point - 2048)/25.0);
    }
    
}
