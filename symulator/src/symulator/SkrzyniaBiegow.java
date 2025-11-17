package symulator;

public class SkrzyniaBiegow extends Komponent {

    public SkrzyniaBiegow(String producent, String model) {
        super(producent, model);
    }

    int aktualnyBieg = 0;
    int iloscBiegow = 6;

    public void zwiekszBieg(){
        aktualnyBieg++;
    }

    public void zmniejszBieg(){
        aktualnyBieg--;
    }
}
