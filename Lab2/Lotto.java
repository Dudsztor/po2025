import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {

        //wprowadzenie swoich liczb
        int liczby[] = new int[6];
        for(int i=0;i<6;i++) {
            liczby[i] = Integer.parseInt(args[i]);
        }
        System.out.print("\nTwoje liczby: ");
        for(int i=0;i<6;i++) {
            System.out.print(liczby[i]+" ");
        }

        //losowanie 6 liczb
        Random rand = new Random();

        ArrayList<Integer> tablica = new ArrayList<Integer>(6);

        for(int i=0;i<6;i++) {
            int losowa = rand.nextInt(49) + 1;
            if (tablica.contains(losowa)) {
                i--;
                continue;
            }
            tablica.add(losowa);
        }

        //sprawdzanie trafień

        int trafione = 0;

        for(int i=0;i<6;i++){
            if(tablica.contains(liczby[i])){
                trafione++;
            }
        }
        System.out.print("\nWylosowane liczby: ");
        for(int i=0;i<6;i++) {
            System.out.print(tablica.get(i)+" ");
        }

        System.out.print("\nIlość trafień: " + trafione);
    }
}