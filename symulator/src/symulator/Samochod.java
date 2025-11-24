package symulator;

public class Samochod {
    private String nrRejestracyjny;
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Sprzeglo sprzeglo;

    public Samochod(String nrRejestracyjny) {
        this.skrzynia = new SkrzyniaBiegow("SkrzyniaCorp", "6-biegowa");
        this.silnik = new Silnik("V8 Motor", "5.0L");
        this.sprzeglo = new Sprzeglo("SprzegloEx", "Sportowe");
        this.nrRejestracyjny = nrRejestracyjny;
    }

    @Override
    public String toString(){
        return "Auto " + nrRejestracyjny;
    }

    public void zwiekszBieg(){
        if ((skrzynia.aktualnyBieg+1 <= skrzynia.iloscBiegow) && sprzeglo.stanSprzegla){
            skrzynia.zwiekszBieg();
            System.out.println("Zwiekszono bieg. Aktualny bieg: "+ skrzynia.aktualnyBieg);
        }
    }

    public void zmniejszBieg(){
        if ((skrzynia.aktualnyBieg > 1) && sprzeglo.stanSprzegla){
            skrzynia.zmniejszBieg();
            System.out.println("Zmniejszono bieg. Aktualny bieg: "+ skrzynia.aktualnyBieg);
        }
    }

    public void wlacz(){
        silnik.uruchom();
        skrzynia.aktualnyBieg = 1;
        System.out.println("Wlaczono samochod");
    }
    public void wylacz(){
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg = 0;
        System.out.println("Wylaczono samochod");
    }

    public void test(){
        System.out.println("test");
    }
}
