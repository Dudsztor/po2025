package symulator;

public class Samochod {
    private String nrRejestracyjny;
    private int maxPredkosc; // Nowe pole do przechowywania prędkości

    // Komponenty publiczne, aby łatwo dostać się do nich z Kontrolera
    public Silnik silnik;
    public SkrzyniaBiegow skrzynia;
    public Sprzeglo sprzeglo;

    // Zaktualizowany konstruktor przyjmujący dane z formularza
    public Samochod(String nrRejestracyjny, int maxPredkosc, int iloscBiegow) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.maxPredkosc = maxPredkosc;

        // Przekazujemy ilość biegów do nowej Skrzyni
        this.skrzynia = new SkrzyniaBiegow("SkrzyniaCorp", "Manual", iloscBiegow);
        this.silnik = new Silnik("V8 Motor", "5.0L");
        this.sprzeglo = new Sprzeglo("SprzegloEx", "Sportowe");
    }

    // Gettery potrzebne do wyświetlania danych w GUI
    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public int getMaxPredkosc() {
        return maxPredkosc;
    }

    @Override
    public String toString() {
        return nrRejestracyjny; // To wyświetla się na liście w ComboBox
    }

    public void zwiekszBieg() {
        // Sprawdzamy, czy nie przekraczamy maksymalnej liczby biegów danej skrzyni
        if ((skrzynia.aktualnyBieg + 1 <= skrzynia.iloscBiegow) && sprzeglo.stanSprzegla) {
            skrzynia.zwiekszBieg();
            System.out.println("Zwiekszono bieg. Aktualny bieg: " + skrzynia.aktualnyBieg);
        } else {
            System.out.println("Nie można zwiększyć biegu (sprzęgło? max bieg?)");
        }
    }

    public void zmniejszBieg() {
        if ((skrzynia.aktualnyBieg > 1) && sprzeglo.stanSprzegla) {
            skrzynia.zmniejszBieg();
            System.out.println("Zmniejszono bieg. Aktualny bieg: " + skrzynia.aktualnyBieg);
        }
    }

    public void wlacz() {
        silnik.uruchom();
        skrzynia.aktualnyBieg = 1; // Na start wrzucamy jedynkę (opcjonalne)
        System.out.println("Wlaczono samochod");
    }

    public void wylacz() {
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg = 0;
        System.out.println("Wylaczono samochod");
    }
}