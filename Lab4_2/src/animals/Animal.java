package animals;

public abstract class Animal {
    protected String name;
    protected int legs;

    public Animal(String var1) {
        this.name = var1;
    }

    public abstract String getDescription();

    public int getLegs() {
        return this.legs;
    }

    public String getName() {
        return this.name;
    }
}
