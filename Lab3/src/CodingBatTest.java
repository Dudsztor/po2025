import org.junit.Test;
import static org.junit.Assert.*;

public class CodingBatTest {

    @org.junit.Test
    public void sleepIn() {
        CodingBat cb = new CodingBat();
        System.out.println(cb.sleepIn(false,false));
        System.out.println(cb.sleepIn(true,false));
        System.out.println(cb.sleepIn(false,true));
    }

    @org.junit.Test
    public void sum28() {
        CodingBat s28 = new CodingBat();
        int[] tablica = {1, 2, 3, 4, 5, 6, 7, 8};
    }

    @org.junit.Test
    public void frontBack() {
        CodingBat fb = new CodingBat();
        System.out.println(fb.frontBack("AbcdefgH"));
    }

    @org.junit.Test
    public void helloName() {
        CodingBat hn = new CodingBat();
        System.out.println(hn.helloName("Krzysztof"));
    }
}