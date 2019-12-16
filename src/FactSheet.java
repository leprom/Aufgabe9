import java.util.LinkedList;

public class FactSheet {
    DemandMatrix x;
    DiffMatrix y1,y2, z;

    int year;
    Weather weather;
    //LinkedList<FactSheet> oldFactSheets;
    FactSheet lastYear;
   
    
    public FactSheet() {
        int streckenabschnittAnzahl = 1000;
        int zeitintervallAnzahl = 24;
        this.x = new DemandMatrix(streckenabschnittAnzahl,zeitintervallAnzahl);
        this.y1 = new DiffMatrix(streckenabschnittAnzahl, zeitintervallAnzahl);
        this.y2 = new DiffMatrix(streckenabschnittAnzahl,zeitintervallAnzahl);
        this.z = new DiffMatrix(streckenabschnittAnzahl,zeitintervallAnzahl);
        int goodWeather = 0;
        int badWeather = 0;

        for (int i = 0; i < streckenabschnittAnzahl; i++) {
            for (int j = 0; j < zeitintervallAnzahl; j++) {
                int passagiereAnzahl = (int)(Math.random()*10000+5000);
                if(passagiereAnzahl>7500) badWeather++;
                else goodWeather++;
                x.addToMatrix(i,j,passagiereAnzahl);
            }
        }

        //хорошая погода
        for (int i = 0; i < streckenabschnittAnzahl; i++) {
            for (int j = 0; j < zeitintervallAnzahl; j++) {
                int passagiereAnzahl = (int)(Math.random()*10000-5000);
                y1.addToMatrix(i,j,passagiereAnzahl);
            }
        }

        // плохая погода
        for (int i = 0; i < streckenabschnittAnzahl; i++) {
            for (int j = 0; j < zeitintervallAnzahl; j++) {
                int passagiereAnzahl = (int)(Math.random()*10000);
                y1.addToMatrix(i,j,passagiereAnzahl);
            }
        }

        // изменение из года в год
        for (int i = 0; i < streckenabschnittAnzahl; i++) {
            for (int j = 0; j < zeitintervallAnzahl; j++) {
                int passagiereAnzahl = (int)(Math.random()*2000-1000);
                z.addToMatrix(i,j,passagiereAnzahl);
            }
        }



        /*if(goodWeather>=badWeather) weather = Weather.GOOD;
        else weather = Weather.BAD;*/
    }

    /**
     * Der Konstruktor erweitert bestehende Daten aus früheren Jahren um ein neues Jahr
     *
     * @param before Daten aus früheren Jahre
     * @param weather das Wetter für das neue Jahr
     */
    public FactSheet(FactSheet before, Weather weather) {
        this.lastYear = before;
        int streckenabschnittAnzahl = 1000;
        int zeitintervallAnzahl = 24;
        //DemandMatrix x =new DemandMatrix( (track, time) -> before.x.getArray()[track][time] +before.z.getArray([track][time]));
    }

    public static void main(String[] args) {
        FactSheet factSheet1 = new FactSheet();
        FactSheet factSheet2 = new FactSheet();
        FactSheet factSheet3 = new FactSheet();

        System.out.println(factSheet1.weather);
        System.out.println(factSheet2.weather);
        System.out.println(factSheet3.weather);
    }
   
}
