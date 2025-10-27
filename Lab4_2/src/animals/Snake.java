package animals;

public class Snake extends Animal {
    public Snake(String var1) {
        super(var1);
        this.name = var1;
        this.legs = 0;
    }

    public String getDescription() {
        return "Jestem " + this.name + " i mam " + this.legs + " nóg.";
    }
}
