package genmatrix;

import java.io.File;

public class EGGFileManager {
    
    String outputFilename = "output-16-channels.csv";
    
    String pathSeparator = File.separator;
    
    char elementSeparator = ',';
    
    int numberOfSamplesPerEpoch = 256;
    
    int numberOfEpochs = 300;
    
    public String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }
    
    public void printCurrentDirectory() {
        System.out.println(getCurrentDirectory());
    }
    
    public void listFilenames() { }

}
