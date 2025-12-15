package symulator;

public class Pozycja {
    public double x;
    public double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("%.2f, %.2f", x, y)
                ;
    }
}