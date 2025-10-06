public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int ilosc_rzedow = Integer.parseInt(args[0]);

        int licznik = 1;

        String gwiazdka = "*";

        while(licznik<ilosc_rzedow+1){
            System.out.println(gwiazdka.repeat(licznik));
            licznik++;
        }
    }
}