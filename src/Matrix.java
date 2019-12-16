import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Matrix {
    private int[][] array;
    private int streckenabschnitt;
    private int zeitintervall;
    //              {0:00-1:00, 1:00-2:00 ... , 23:00}
    // Участок 0:    140   134

    public int[][] getArray() {
        return array;
    }
    // Участок 1:
    /*
    //Variablen:
    1)
    // zweidimensionales Array
    // eine Demension: участки маршрута в сети железных дорог
    // zweite: временным интервалам в течение рождественскогосезона
    не менее 1000 участков маршрута и 24 временных интервала, индексы представлены целыми числами*/



    public void addToMatrix(int streckenabschnitt, int zeitintervall, int passagiereAnzahl) {
            array[streckenabschnitt][zeitintervall] = passagiereAnzahl;

    }

    /**
     * Задает участки путей и интервалы для них.
     *
     * @param streckenabschnittAnzahl
     * @param zeitintervallAnzahl
     */
    public Matrix(int streckenabschnittAnzahl, int zeitintervallAnzahl) {
        if (streckenabschnittAnzahl < 1000) {
            throw new ExceptionInInitializerError("streckenabschnittAnzahl muss >=1000 sein");
        } else if(zeitintervallAnzahl <24) {
            throw new ExceptionInInitializerError("zeitintervallAnzahl muss >=24 sein");
        }
        else {
            array = new int[streckenabschnittAnzahl][zeitintervallAnzahl];
            this.streckenabschnitt = streckenabschnittAnzahl;
            this.zeitintervall = zeitintervallAnzahl;
        }
    }

    public int get(int track, int time){
        return array[track][time];
    }


    // метод, который делает данные доступными через внутренний итератор.

    public IntStream getStreamOfDemandMatrix(){
        // Stream <int[][]> stream = (Stream<int[][]>) Arrays.stream(array);
        // Stream stream = Arrays.stream(array);
        // IntStream stream = Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x));

        IntStream stream = Arrays.stream(array).flatMapToInt(Arrays::stream);

        return stream;
    }

    public void getValuesOfDemandMatrix() {
        IntStream intStream = getStreamOfDemandMatrix();
        intStream.forEach(x -> {
            System.out.println(x);
        });
    }

    public int get(Object track, Object time) {
        int a = (Integer) track;
        int b = (Integer) time;
        return array[a][b];
    }





/*

Каждая запись массива соответствует неотрицательному числу пассажиров, которые
путешествовали или должны проехать на соответствующем участке маршрута за соответствующий промежуток времени.
Объекты этого типа не могут быть изменены после создания. В дополнение к одному или нескольким конструкторам,
требуется метод, который делает данные доступными через внутренний итератор.


     */
}
