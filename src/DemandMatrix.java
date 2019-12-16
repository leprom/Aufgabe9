public class DemandMatrix extends Matrix{

    /**
     * Задает участки путей и интервалы для них.
     *
     * @param streckenabschnittAnzahl
     * @param zeitintervallAnzahl
     */
    public DemandMatrix(int streckenabschnittAnzahl, int zeitintervallAnzahl) {
        super(streckenabschnittAnzahl, zeitintervallAnzahl);
    }

    @Override
    public void addToMatrix(int streckenabschnitt, int zeitintervall, int passagiereAnzahl) {
        if (passagiereAnzahl >= 0) {
            super.addToMatrix(streckenabschnitt, zeitintervall, passagiereAnzahl);
        } else throw new ExceptionInInitializerError("passagiereAnzahl muss >=0 sein");

    }



}