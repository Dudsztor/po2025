public class main {
    public static void main(String[] args) {
        CodingBat cb = new CodingBat();

        System.out.println(cb.sleepIn(false,false));
        System.out.println(cb.sleepIn(true,false));
        System.out.println(cb.sleepIn(false,true));

        CodingBat fb = new CodingBat();
        System.out.println(fb.frontBack("AbcdefgH"));

        CodingBat s28 = new CodingBat();

        int[] tablica = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(s28.sum28(tablica));

        CodingBat hn = new CodingBat();
        System.out.println(hn.helloName("Krzysztof"));
    }

}
