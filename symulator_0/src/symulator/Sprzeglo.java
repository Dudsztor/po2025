package symulator;

public class Sprzeglo extends Komponent{

    public Sprzeglo(String producent, String model) {
        super(producent, model);
    }

    public boolean stanSprzegla;

    public void wcisnij(){
        stanSprzegla = true;
    }
    public void zwolnij(){
        stanSprzegla = false;
    }
}
