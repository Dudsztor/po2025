//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package zadania;

import animals.Animal;
import animals.Dog;
import animals.Parrot;
import animals.Snake;
import java.util.Random;

public class Zoo {
    Animal[] animals = new Animal[100];
    private final Random randomGenerator = new Random();

    private void fillTheZoo() {
        for(int var1 = 0; var1 < this.animals.length; ++var1) {
            int var2 = this.randomGenerator.nextInt(3);
            switch (var2) {
                case 0:
                    this.animals[var1] = new Parrot("Marta_" + var1);
                    String opis = animals[var1].getDescription();
                    System.out.println(opis);
                    break;
                case 1:
                    this.animals[var1] = new Dog("Seba_" + var1);
                    opis = animals[var1].getDescription();
                    System.out.println(opis);
                    break;
                case 2:
                    this.animals[var1] = new Snake("Franek_" + var1);
                    opis = animals[var1].getDescription();
                    System.out.println(opis);
            }
        }

    }

    public Zoo() {
        this.fillTheZoo();
    }

    public int countAllLegs() {
        int var1 = 0;

        for(Animal var5 : this.animals) {
            if (var5 != null) {
                var1 += var5.getLegs();
            }
        }

        return var1;
    }

    static void main(String[] var0) {
        Zoo var1 = new Zoo();
        int var2 = var1.countAllLegs();
        System.out.println("Całkowita liczba nóg wszystkich zwierząt w ZOO: " + var2);
    }
}
