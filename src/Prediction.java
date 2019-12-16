public class Prediction {

 FactSheet factSheet;
    Weather weather;

    /**
     * Das vorhergesagte Wetter wird zufällig gewählt
     * @param factSheet
     */
    public Prediction(FactSheet factSheet) {
        this.factSheet = factSheet;

        double random = Math.random();
        if(random>=0.5) weather=Weather.BAD;
        else weather=Weather.GOOD;
    }

}
