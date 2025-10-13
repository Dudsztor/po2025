import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {

        Random rand = new Random();
        
        ArrayList<Integer> tablica = new ArrayList<Integer>(6);

        for(int i=0;i<6;i++){
            int losowa = rand.nextInt(49) + 1;
            if(tablica.contains(losowa)){
                i--;
                continue;
            }
            tablica.add(losowa);
        }
        for(int i : tablica){
            System.out.println(i);
        }
    }
}