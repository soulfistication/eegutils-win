/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genmatrix;

/**
 *
 * @author Ivan Almada
 */
public class Main {

    /**
     * @param Command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("GenMatrix ver: " + EEGFileManager.programVersion + "\n");
        
        EpochSegmentator.ParadigmType requestedType = EpochSegmentator.ParadigmType.P1;
        
        if (args.length != 1) {
            System.out.println("Usage: java -jar GenMatrix.jar <Type>");
            System.out.println("<Type> = P1 | EG | P3 | N4 | EM\n");
        } else {
            if (args[0].equalsIgnoreCase("P1")) {
                requestedType = EpochSegmentator.ParadigmType.P1;
            } else if (args[0].equalsIgnoreCase("EG")) {
                requestedType = EpochSegmentator.ParadigmType.EG;
            } else if (args[0].equalsIgnoreCase("P3")) {
                requestedType = EpochSegmentator.ParadigmType.P3;
            } else if (args[0].equalsIgnoreCase("N4")) {
                requestedType = EpochSegmentator.ParadigmType.N4;
            } else if (args[0].equalsIgnoreCase("EM")) {
                requestedType = EpochSegmentator.ParadigmType.EM;
            } else {
                System.out.println("Paradigm type not recognized");
                return;
            }
        }
        
        MatrixGenerator generator = new MatrixGenerator(requestedType);
        generator.generate();
        
        EpochSegmentator segmentator = new EpochSegmentator(requestedType);
        segmentator.segment();
        
    }

}
