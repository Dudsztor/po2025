package symulator;

public class Samochod {
    Silnik  silnik;
    SkrzyniaBiegow skrzynia;

    void wlacz(){
        silnik.uruchom();
    }
    void wylacz(){
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg = 0;
    }
}
