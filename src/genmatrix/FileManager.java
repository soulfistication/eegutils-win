package genmatrix;

import java.io.File;

public class FileManager {
    
    String outputFilename = "output.csv";
    String pathSeparator = File.separator;
    char elementSeparator = ',';
    
    public String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }
    
    public void printCurrentDirectory() {
        System.out.println(getCurrentDirectory());
    }
    
    public void listFilenames() { }

}
