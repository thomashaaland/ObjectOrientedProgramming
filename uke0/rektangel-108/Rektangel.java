class Rektangel {

    double lengde;
    double bredde;
    
    public Rektangel (double l, double b) {
	// Konstruktør
	lengde = l;
	bredde = b;
    }

    public void oekLengde (int okning) { // Oek lengden som angitt
	lengde = lengde + okning;
    }

    public void oekBredde (int okning) { // Oek bredden som angtt
	bredde = bredde + okning;
    }

    public void reduserLengde (int minking) {
	if (lengde - minking < 0) {
	    System.out.println("Lengden kan ikke reduseres så mye.")
		}
	else {
	    lengde = lengde - minking;
	}
    }

    public void reduserBredde (int minking) {
	if (bredde - minking < 0) {
	    System.out.println("Bredden kan ikke reduseres så mye.")
		}
	else {
	    bredde = bredde - minking;
	}
    }
    
    public double areal () { // beregn mitt areal
	return bredde * lengde;
    }

    public double omkrets () { // beregn min omkrets
	return 2 * bredde + 2 * lengde;
    }
}
