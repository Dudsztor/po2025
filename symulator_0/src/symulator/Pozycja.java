package symulator;

public class Pozycja {
    double x;
    double y;

    void aktualizujPozycje(double deltax, double deltay) {
        this.x = this.x + deltax;
        this.y = this.y + deltay;
    }

    String getPozycja() {
        return "Pozycja " + x + " " + y;
    }
}
