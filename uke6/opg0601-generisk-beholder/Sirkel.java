import java.lang.Math.*;

class Sirkel extends Figur {
    public Sirkel(double radius) {
	a = radius;
    }

    public double area() {
	return Math.PI * a * a;
    }
}
