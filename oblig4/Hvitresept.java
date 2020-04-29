/* 
   Hvit resept, har de samme egenskapene som resept, men er ikke
   abstrakt. Har fargen hvit og mangler rabatt.
*/

public class Hvitresept extends Resept {

    // Variable
    static final private String farge = "Hvit";
    
    // Konstruktor
    public Hvitresept(Legemiddel legemiddel, Lege utskrivendeLege,
		      Pasient pasient, int reit) {
	super(legemiddel, utskrivendeLege, pasient, reit);
    }


    // Getters
    public String farge() {
	return farge;
    }

    public double prisAaBetale() {
	return legemiddel.hentPris();
    }

    // toString();
    @Override
    public String toString() {
	return farge + "resept-" + super.toString() +
	    "\n\t\t-Pris å betale: " + prisAaBetale();
    }
}
