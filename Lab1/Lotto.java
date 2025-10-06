import java.util.Arrays;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {

        Random rand = new Random();

        int[] tablica = new int[6];
        int[] czy_byly = new int[6];

        for (int i = 0; i < tablica.length; i++) {

            boolean check = true;
                while(check){
                    int test = rand.nextInt(10);
                    if(!Arrays.asList(czy_byly[i]).contains(tablica[i])){
                        Arrays.asList(czy_byly[i]).add(test);
                      check = false;
                    }


                }

            }

        System.out.println("Czy byly: " + Arrays.toString(czy_byly));
        }


    }
