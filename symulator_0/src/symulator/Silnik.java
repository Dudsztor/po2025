package symulator;

public class Silnik extends Komponent{

    public Silnik(String producent, String model) {
        super(producent, model);
    }

    int maxObroty = 90000;
    int obroty;

    void uruchom(){
        obroty = 900;
    }

    void zatrzymaj(){
        obroty = 0;
    }
}
