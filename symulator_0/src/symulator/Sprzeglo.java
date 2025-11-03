package symulator;

public class Sprzeglo extends Komponent{

    public Sprzeglo(String producent, String model) {
        super(producent, model);
    }

    boolean stanSprzegla;

    void wcisnij(){
        stanSprzegla = true;
    }
    void zwolnij(){
        stanSprzegla = false;
    }
}
