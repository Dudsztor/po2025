package animals;

public class Dog extends Animal {
    public Dog(String var1) {
        super(var1);
        this.legs = 4;
    }

    public String getDescription() {
        return "Jestem " + this.name + " i mam " + this.legs + " nóg.";
    }
}
