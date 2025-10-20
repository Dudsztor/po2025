import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {

        // wprowadzenie swoich liczb
        int[] liczby = new int[6];
        for (int i = 0; i < 6; i++) {
            liczby[i] = Integer.parseInt(args[i]);
        }
        //System.out.print("\nTwoje liczby: ");
        //for (int i = 0; i < 6; i++) {
        //    System.out.print(liczby[i] + " ");
        //}

        long czas = System.currentTimeMillis();
        int wynik = graj(liczby);
        int ilosc_losowan = 1;

        while(wynik != 6) {
            wynik = graj(liczby);
            ilosc_losowan++;
            //System.out.println("\nIlość trafień: " + wynik);
        }
        long czas2 = System.currentTimeMillis();
        System.out.println("Potrzebny czas: " + (czas2 - czas) + " [ms]");
        System.out.println("Ilosc losowan: " + ilosc_losowan);
    }
    // graj
    public static int graj(int[] liczby) {

        // losowanie 6 liczb
        Random rand = new Random();
        ArrayList<Integer> tablica = new ArrayList<>(6);

        for (int i = 0; i < 6; i++) {
            int losowa = rand.nextInt(49) + 1;
            if (tablica.contains(losowa)) {
                i--;
                continue;
            }
            tablica.add(losowa);
        }

        // sprawdzanie trafień
        int trafione = 0;
        for (int i = 0; i < 6; i++) {
            if (tablica.contains(liczby[i])) {
                trafione++;
            }
        }

        //System.out.print("\nWylosowane liczby: ");
        //for (int i = 0; i < 6; i++) {
        //    System.out.print(tablica.get(i) + " ");
        //}

        return trafione;
    }
}