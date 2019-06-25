package genmatrix;

public class Main {

    public static void main(String[] args) {
        
        MatrixGenerator creator = new MatrixGenerator();
        creator.generate();
        
        EpochSegmentator seq = new EpochSegmentator();
        seq.segment();
    }

}
