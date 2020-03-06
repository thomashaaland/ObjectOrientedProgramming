class Rektangel extends Figur {
    public Rektangel (double bredde, double hoyde) {
	a = bredde;
	b = hoyde;
    }

    public double area() {
	return a * b;
    }
}
