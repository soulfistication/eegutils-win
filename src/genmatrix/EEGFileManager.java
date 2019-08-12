package genmatrix;

import java.io.File;

public class EEGFileManager {
   
    public static String programVersion = "1.3.2";
    
    public static String pathSeparator = File.separator;
    public static char elementSeparator = '\t';
    
    public int numberOfLines;
    
    protected String[] rawDataset1 = {
        "F1.DAT", "F3.DAT", "C3.DAT", "P3.DAT",
        "O1.DAT", "F7.DAT", "T3.DAT", "T5.DAT"
    };
    
    protected String[] rawDataset2 = {
        "F2.DAT", "F4.DAT", "C4.DAT", "P4.DAT",
        "O2.DAT", "F8.DAT", "T4.DAT", "T6.DAT"
    };
    
    protected String[] dataset1;
    protected String[] dataset2;
    
    protected enum ParadigmType {
        P1,
        EG,
        P3,
        N4,
        EM
    }
    
    protected ParadigmType type;
    
    EEGFileManager(ParadigmType type) {
        this.type = type;
        
        dataset1 = rawDataset1.clone();
        
        for (int i = 0; i < dataset1.length; i++) {
            dataset1[i] = getParadigmTypePrefix() + dataset1[i];
        }
        
        dataset2 = rawDataset2.clone();
        
        for (int i = 0; i < rawDataset2.length; i++) {
            dataset2[i] = getParadigmTypePrefix() + dataset2[i];
        }

        numberOfLines = numberOfSamplesPerEpoch() * getNumberOfEpochs();
    }
    
    public int numberOfSamplesPerEpoch() {
        switch (type) {
            case P1:
                return 128;
            default:
                return 256;
        }
    }
    
    protected String getParadigmTypePrefix() {
        switch (type) {
            case P1:
                return "P1";
            case EG:
                return "EG";
            case P3:
                return "P3";
            case N4:
                return "N4";
            case EM:
                return "EM";
            default:
                return "";
        }
    }
    
    protected String getOutputFileName() {
        switch (type) {
            case P1:
                return "P1.asc";
            case EG:
                return "EG.asc";
            default:
                return "epochall.asc";
        }
    }
    
    protected int getNumberOfEpochs() {
        int numberOfEpochs = 0;
        switch(type) {
            case P1:
                numberOfEpochs = 180;
                break;
            case EG:
                numberOfEpochs = 180;
                break;
            case P3:
                numberOfEpochs = 300;
                break;
            case N4:
                numberOfEpochs = 118;
                break;
            case EM:
                numberOfEpochs = 300;
                break;
            default:
                numberOfEpochs = 300;
                break;
        }
                
        return numberOfEpochs;
    }
    
    public String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }
    
    public void printCurrentDirectory() {
        System.out.println(getCurrentDirectory());
    }
    
    public void listFilenames() {
        for (String filename : dataset1) {
            System.out.println(filename);
        }
        
        for (String filename : dataset2) {
            System.out.println(filename);
        }
    }

}
