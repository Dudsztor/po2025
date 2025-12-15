package symulator;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class Samochod extends Thread {
    private String nrRejestracyjny;
    private String model;
    private int maxPredkosc;
    private double wagaCalkowita;

    public Silnik silnik;
    public SkrzyniaBiegow skrzynia;
    public Sprzeglo sprzeglo;

    private Pozycja pozycja;
    private Pozycja cel;
    private double aktualnaPredkosc = 0;
    private List<Listener> listeners = new ArrayList<>();

    public Samochod(String model, String nrRejestracyjny, double waga, int maxPredkosc,
                    Silnik silnik, SkrzyniaBiegow skrzynia, Sprzeglo sprzeglo) {
        this.model = model;
        this.nrRejestracyjny = nrRejestracyjny;
        this.maxPredkosc = maxPredkosc;

        this.wagaCalkowita = waga + silnik.getWaga() + sprzeglo.getWaga() + skrzynia.getWaga();

        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
        this.pozycja = new Pozycja(0, 0);

        start();
    }

    @Override
    public void run() {
        double deltat = 0.1;
        while (true) {
            try {
                Thread.sleep(10);
                przeliczPredkosc();
                if (cel != null && aktualnaPredkosc > 0) {
                    double odleglosc = Math.sqrt(Math.pow(cel.x - pozycja.x, 2) + Math.pow(cel.y - pozycja.y, 2));
                    if (odleglosc > deltat*100) {
                        double dx = aktualnaPredkosc * deltat * (cel.x - pozycja.x) / odleglosc;
                        double dy = aktualnaPredkosc * deltat * (cel.y - pozycja.y) / odleglosc;
                        pozycja.x += dx;
                        pozycja.y += dy;
                    } else {
                        pozycja.x = cel.x;
                        pozycja.y = cel.y;
                        cel = null;
                    }
                }
                notifyListeners();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void przeliczPredkosc() {
        if (sprzeglo.isWcisniete() || skrzynia.getAktualnyBieg() == 0) {
            aktualnaPredkosc = 0;
        } else {
            double obroty = silnik.getObroty();
            int bieg = skrzynia.getAktualnyBieg();
            double wyliczonaPredkosc = (obroty * bieg) / 300.0;
            if (wyliczonaPredkosc > maxPredkosc) {
                wyliczonaPredkosc = maxPredkosc;
            }
            this.aktualnaPredkosc = wyliczonaPredkosc;
        }
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    private void notifyListeners() {
        for (Listener listener : listeners)
            listener.update();
    }

    public void jedzDo(Pozycja p) {
        this.cel = p;
    }

    public Pozycja getPozycja() {
        return pozycja;
    }
    public double getAktualnaPredkosc() {
        return Math.round(aktualnaPredkosc);
    }
    public double getMaxPredkosc() {
        return maxPredkosc;
    }
    public void wlacz() {
        silnik.uruchom();
    }
    public void wylacz() {
        silnik.zatrzymaj();
    }
    public void zwiekszBieg() throws pokazBlad {
        if(sprzeglo.isWcisniete()) {
            skrzynia.zwiekszBieg();
        } else {
            throw new pokazBlad("Sprzęgło nie jest wciśnięte!");
        }
    }
    public void zmniejszBieg() throws pokazBlad {
        if(sprzeglo.isWcisniete()) {
            skrzynia.zmniejszBieg();
        } else {
            throw new pokazBlad("Sprzęgło nie jest wciśnięte!");
        }
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }
    public String getModel() {
        return model;
    }
    public double getWaga() {
        return wagaCalkowita;
    }
    @Override public String toString() {
        return model + " (" + nrRejestracyjny + ")";
    }
}