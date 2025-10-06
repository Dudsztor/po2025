import java.util.Arrays;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] tablica = new int[6];

        int licznik = 0;

        while(licznik < 6){
            int potencjalne = rand.nextInt(49) + 1;
            boolean exist = false;

            for(int i=0; i<licznik; i++){
                if (tablica[i] == potencjalne){
                    exist = true;
                    break;
                }
            }
            if (!exist){
                tablica[licznik] = potencjalne;
                System.out.print(tablica[licznik] + " ");
                licznik++;
            }
        }
    }
}