package symulator;

public class main {


    public static void main(String[] args) {

        SkrzyniaBiegow skrzynia;
        Silnik silnik;
        Sprzeglo sprzeglo;

        skrzynia = new SkrzyniaBiegow("Toyota", "T-55");
        silnik = new Silnik("Audi", "CDS");
        sprzeglo = new Sprzeglo("Fiat", "SSB");

        Samochod auto = new Samochod(skrzynia, silnik, sprzeglo);
        auto.wlacz();

        sprzeglo.zwolnij();
        sprzeglo.wcisnij();

        auto.zwiekszBieg();

        sprzeglo.zwolnij();

        auto.zwiekszBieg();
        auto.zwiekszBieg();

        sprzeglo.wcisnij();

        auto.zwiekszBieg();
        auto.zwiekszBieg();
        auto.zwiekszBieg();
        auto.zwiekszBieg();
    }
}
