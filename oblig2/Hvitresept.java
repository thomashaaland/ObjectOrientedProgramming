/* 
   Hvit resept, har de samme egenskapene som resept, men er ikke
   abstrakt. Har fargen hvit og mangler rabatt.
*/

public class Hvitresept extends Resept {

    // Variable
    static final private String farge = "Hvit";
    
    // Konstruktor
    public Hvitresept(Legemiddel legemiddel, Lege utskrivendeLege,
		      int pasientId, int reit) {
	super(legemiddel, utskrivendeLege, pasientId, reit);
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
	return farge + "resept \t- " + super.toString() +
	    "\t- Pris å betale: " + prisAaBetale();
    }
}
