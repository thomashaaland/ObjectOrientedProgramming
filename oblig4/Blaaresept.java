public class Blaaresept extends Resept {
    // Deklarer variable
    static final private double rabatt = 0.75;
    static final private String farge = "Blå";

    // Konstruktør
    Blaaresept(Legemiddel legemiddel, Lege utskrivendeLege,
	       Pasient pasient, int reit) {
	super(legemiddel, utskrivendeLege, pasient, reit);
    }

    // Getters
    @Override
    public String farge() {
	return farge;
    }

    @Override
    public double prisAaBetale() {
	return legemiddel.hentPris() * (1-rabatt);
    }

    @Override
    public String toString() {
	return farge() + "resept- " + super.toString() +
	    "\t- Pris å betale: " + prisAaBetale();
    }
}
