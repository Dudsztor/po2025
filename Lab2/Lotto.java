import java.util.Random;

public class Lotto {
    public static void main(String[] args) {

        //wprowadzenie swoich liczb
        int liczby[] = new int[6];
        for(int i=0;i<6;i++) {
            liczby[i] = Integer.parseInt(args[i]);
        }

        //losowanie 6 liczb
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
            for(int i=0; i<licznik; i++){

            }
        }

        //sprawdzanie trafień
        int trafione = 0;

        for(int i=0; i<6; i++){
            for (int j=0; j<licznik; j++){
                if(liczby[i] == tablica[j]){
                        trafione++;
                }
            }
        }

        System.out.print("\nIlosc trafien: " + trafione);
    }
}