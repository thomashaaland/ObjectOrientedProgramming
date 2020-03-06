class Triangel extends Figur {
    public Triangel (double grunnLinje, double hoyde) {
	a = grunnLinje;
	b = hoyde;
    }

    public double area() {
	return a * b / 2;
    }
}
