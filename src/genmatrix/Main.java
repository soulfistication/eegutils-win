package genmatrix;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("GenMatrix ver:" + EEGFileManager.programVersion);
        System.out.println();
        
        int numberOfEpochs = 0;
        
        if (args.length == 0) {
           numberOfEpochs = 300; // Default is 300 epochs.
        }
        
        if (args.length != 1) {
            System.out.println("Usage: java -jar GenMatrix.jar <Type>");
            System.out.println("Where <Type> = A | B");
            System.out.println("<Type> A takes 300 epochs.");
            System.out.println("<Type> B takes 118 epochs.");
        } else {
            if (args[0].equals("A")) {
                numberOfEpochs = 300;
            } else if (args[0].equals("B")) {
                numberOfEpochs = 118;
            }
        }
        
        MatrixGenerator generator = new MatrixGenerator(numberOfEpochs);
        generator.generate();
        
        EpochSegmentator segmentator = new EpochSegmentator(numberOfEpochs);
        segmentator.segment();
    }

}
