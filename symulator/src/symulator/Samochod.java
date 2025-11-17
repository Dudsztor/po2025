package symulator;

public class Samochod {
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Sprzeglo sprzeglo;

    public Samochod(SkrzyniaBiegow skrzynia, Silnik silnik, Sprzeglo sprzeglo) {
        this.skrzynia = skrzynia;
        this.silnik = silnik;
        this.sprzeglo = sprzeglo;
    }

    public void zwiekszBieg(){
        if ((skrzynia.aktualnyBieg+1 <= skrzynia.iloscBiegow) && sprzeglo.stanSprzegla){
            skrzynia.zwiekszBieg();
        }
    }

    public void zmniejszBieg(){
        if ((skrzynia.aktualnyBieg > 1) && sprzeglo.stanSprzegla){
            skrzynia.zmniejszBieg();
        }
    }

    public void wlacz(){
        silnik.uruchom();
        skrzynia.aktualnyBieg = 1;
    }
    public void wylacz(){
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg = 0;
    }

    public void test(){
        System.out.println("test");
    }
}
