package symulator;

public class Silnik extends Komponent {
    private int maxObroty;
    private int obroty;
    private boolean wlaczony;

    public Silnik(String nazwa, double waga, double cena, int maxObroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = 0;
        this.wlaczony = false;
    }

    public void uruchom() {
        this.wlaczony = true;
        this.obroty = 800;
    }

    public void zatrzymaj() {
        this.wlaczony = false;
        this.obroty = 0;
    }

    public void zwiekszObroty(){
        if (wlaczony && obroty < maxObroty) {
            obroty += 100;
        }
    }

    public void zmniejszObroty(){
        if (wlaczony && obroty > 800) {
            obroty -= 100;
        }
    }
    public int getObroty() { return obroty; }
}