package symulator;

public class main {


    public static void main(String[] args) {

        SkrzyniaBiegow skrzynia;
        Silnik silnik;
        Sprzeglo sprzeglox;

        skrzynia = new SkrzyniaBiegow("Toyota", "T-55");
        silnik = new Silnik("Audi", "CDS");
        sprzeglox = new Sprzeglo("Fiat", "SSB");

        Samochod auto = new Samochod(skrzynia, silnik);
        auto.wlacz();

        sprzeglox.zwolnij();
        sprzeglox.wcisnij();

        auto.zwiekszBieg();
        auto.zwiekszBieg();
        auto.zwiekszBieg();
        auto.zwiekszBieg();
        auto.zwiekszBieg();
        auto.zwiekszBieg();
        auto.zwiekszBieg();
    }
}
