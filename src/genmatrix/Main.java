package genmatrix;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("GenMatrix ver: " + EEGFileManager.programVersion + "\n");
        
        EpochSegmentator.ParadigmType requestedType = EpochSegmentator.ParadigmType.P1; // Default is P1
        
        if (args.length != 1) {
            System.out.println("Usage: java -jar GenMatrix.jar <Type>");
            System.out.println("Where <Type> = P1 | EG | P3 | N4 | EM");
        } else {
            if (args[0].equals("P1")) {
                requestedType = EpochSegmentator.ParadigmType.P1;
            } else if (args[0].equals("EG")) {
                requestedType = EpochSegmentator.ParadigmType.EG;
            } else if (args[0].equals("P3")) {
                requestedType = EpochSegmentator.ParadigmType.P3;
            } else if (args[0].equals("N4")) {
                requestedType = EpochSegmentator.ParadigmType.N4;
            } else if (args[0].equals("EM")) {
                requestedType = EpochSegmentator.ParadigmType.EM;
            }
        }
        
        MatrixGenerator generator = new MatrixGenerator(requestedType);
        generator.generate();
        
        EpochSegmentator segmentator = new EpochSegmentator(requestedType);
        segmentator.segment();
    }

}
