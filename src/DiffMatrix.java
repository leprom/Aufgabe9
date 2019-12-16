public class DiffMatrix extends Matrix  {



    public DiffMatrix(int streckenabschnittAnzahl, int zeitintervallAnzahl) {
        super(streckenabschnittAnzahl, zeitintervallAnzahl);
    }


    public static void main(String[] args) {
        DiffMatrix diffMatrix = new DiffMatrix(1000,24);
        diffMatrix.getStreamOfDemandMatrix();
    }


// wie demend, aber Arrayeinträge können auch negativ sein.

}
