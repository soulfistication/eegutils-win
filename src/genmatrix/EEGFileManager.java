package genmatrix;

import java.io.File;

public class EEGFileManager {
   
    public static String programVersion = "1.2";
    
    public static String outputFilename = "epochall.asc";
    public static String pathSeparator = File.separator;
    public static char elementSeparator = '\t';
    
    public int numberOfSamplesPerEpoch = 256;
    public int numberOfEpochs; // dynamic
    public int numberOfLines;
    
    EEGFileManager(int numberOfEpochs) {
        this.numberOfEpochs = numberOfEpochs;
        numberOfLines = numberOfEpochs * numberOfSamplesPerEpoch;
    }
    
    public String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }
    
    public void printCurrentDirectory() {
        System.out.println(getCurrentDirectory());
    }
    
    public void listFilenames() { }

}
