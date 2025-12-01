package symulator;

public class SkrzyniaBiegow extends Komponent {

    public int aktualnyBieg = 0;
    public int iloscBiegow;

    public SkrzyniaBiegow(String producent, String model, int iloscBiegow) {
        super(producent, model);
        this.iloscBiegow = iloscBiegow;
    }

    public void zwiekszBieg() {
        aktualnyBieg++;
    }

    public void zmniejszBieg() {
        aktualnyBieg--;
    }
}