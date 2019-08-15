/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genmatrix;

import java.io.File;

/**
 *
 * @author Ivan Almada
 */

public class EEGFileManager {

    public static String programVersion = "1.3.3";
    
    public static String pathSeparator = File.separator;
    public static char elementSeparator = '\t';
    
    public int numberOfLines;
    
    protected String[] rawDataset1 = {
        "F1.DAT", "F3.DAT", "C3.DAT", "P3.DAT",
        "O1.DAT", "F7.DAT", "T3.DAT", "T5.DAT"
    };
    
    protected String[] rawDataset2 = {
        "F2.DAT", "F4.DAT", "C4.DAT", "P4.DAT",
        "02.DAT", "F8.DAT", "T4.DAT", "T6.DAT"
    };
    
    protected String[] dataset1;
    protected String[] dataset2;
    
    protected enum ParadigmType {
        P1, EG, P3, N4, EM
    }
    
    protected ParadigmType type;
    
    EEGFileManager(ParadigmType type) {
        this.type = type;
        
        dataset1 = new String[8];
        
        for (int i=0; i < rawDataset1.length; i++) {
            dataset1[i] = getParadigmTypePrefix() + rawDataset1[i];
        }

        dataset2 = new String[8];
        
        for (int i=0; i < dataset2.length; i++) {
            dataset2[i] = getParadigmTypePrefix() + rawDataset2[i];
        }
        
        numberOfLines = getNumberOfSamplesPerEpoch() * getNumberOfEpochs();
    }
    
    protected int getNumberOfSamplesPerEpoch() {
        switch (type) {
            case P1:
                return 128;
            default:
                return 256;
        }
    }
    
    protected int getNumberOfEpochs() {
        int numberOfEpochs = 0;
        switch (type) {
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
    
    protected String getOutputFilename() {
        switch (type) {
            case P1:
                return "P1.asc";
            case EG:
                return "EG.asc";
            default:
                return "Epochall.asc";
        }
    }
    
    protected String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }
    
    protected void printCurrentDirectory() {
        System.out.println( getCurrentDirectory() );
    }
    
    protected void listFilenames() {
        for (String filename: dataset1) {
            System.out.println(filename);
        }
        for (String filename: dataset2) {
            System.out.println(filename);
        }
    }
}
