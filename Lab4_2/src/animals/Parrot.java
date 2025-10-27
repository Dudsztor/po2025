package animals;

public class Parrot extends Animal {
    public Parrot(String var1) {
        super(var1);
        this.name = var1;
        this.legs = 2;
    }

    public String getDescription() {
        return "Jestem " + this.name + " i mam " + this.legs + " nóg.";
    }
}
