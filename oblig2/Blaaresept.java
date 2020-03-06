public class Blaaresept extends Resept {
    // Deklarer variable
    static final private double rabatt = 0.75;
    static final private String farge = "Blå";

    // Konstruktør
    Blaaresept(Legemiddel legemiddel, Lege utskrivendeLege,
	       int pasientId, int reit) {
	super(legemiddel, utskrivendeLege, pasientId, reit);
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
	return farge() + "resept \t- " + super.toString() +
	    "\t- Pris å betale: " + prisAaBetale();
    }
}
