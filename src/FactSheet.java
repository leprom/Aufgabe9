import java.util.LinkedList;

public class FactSheet {
    DemandMatrix x;
    DiffMatrix y1,y2, z;

    int year;
    Weather weather;
    //LinkedList<FactSheet> oldFactSheets;
    FactSheet lastYear;
    /**
     * Как минимум 5000 пассажиров есть всегда, при любой погоде
     * При хорошей может быть около 0
     * При плохой
     */
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
    /*
    Objekt stellt generierte Fakten zu Passagierzahlen
und der Wetterlage zur Weihnachtszeit aus vergangenen Jahren
bereit.

Verkettet in einer linearen Liste, wobei jeder Eintrag (neben den Daten eines Jahres) ein Objekt
vom Typ FactSheet für Daten früherer Jahre enthält.

Fakten sind nur über interne Iteratoren
abfragbar, deren Details auf verschiedene Weise gestaltbar sind.
     */


    /*

    ХРАНИТЬ В LINKELIST

    Variablen:
    кол-во пассажиров
    год
    погода

Конструктор
    • X vom Typ DemandMatrix mit Zufallszahlen, die eine Weihnachtszeit
mit Durchschnittswetter beschreiben;
• Y1 und Y2 vom Typ DiffMatrix mit Zufallszahlen, die Abweichungen
zu X bei Schönwetter (Y1) und Schlechtwetter (Y2)
beschreiben;
отклонениями к X в хорошую погоду (Y1) и плохую погоду (Y2)

• Z vom Typ DiffMatrix mit Zufallszahlen (in einem gegenüber
Y1 und Y2 deutlich kleineren Wertebereich), die jährliche
Trendverschiebungen bei den Passagierzahlen darstellen.
со случайными числами (в значительно меньшем диапазоне значений, чем Y1 и Y2),
которые представляют годовые сдвиги трендов в количестве пассажиров.

После случайного выбора погоды конструктор без параметров из X, Y1 и Y2 генерирует факты для первого рассматриваемого
года, которые доступны извне через внутренние итераторы. Дополнительный конструктор расширяет существующие данные за
предыдущие годы на новый год, посредством чего данные за предыдущие годы (объект FactSheet) и погода для нового года
передаются в качестве параметров. Данные из X и Z за предыдущий год добавляются элемент за элементом и немного
изменяются путем добавления случайных чисел (из небольшого диапазона значений); это дает X на новый год. Y1, Y2 и Z
с предыдущего года также принимаются в новом году с небольшим изменением путем добавления случайных чисел.
Наконец, факты за новый год основаны на X, Y1 и Y2 в зависимости от погоды.


    Такой объект предоставляет сгенерированные факты о количестве пассажиров и
    погодной ситуации во время Рождества за предыдущие годы, связанные в линейный список,
    причем каждая запись (в дополнение к данным за год) содержит объект типа FactSheet для
    данных за предыдущие годы. Факты могут быть запрошены только через внутренние итераторы,
    детали которых могут быть разработаны по-разному. Конструктор без параметров генерирует следующие данные,
     к которым нельзя получить доступ извне:
     */
}
