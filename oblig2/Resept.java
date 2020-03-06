/* 
   Abstrakt klasse Resept. Tar inn variablene Legemiddel legemiddel,
   Lege utskrivende lege, int pasientId og int reit. 
   Reit er gjenværende resepter. Kan ikke skrive ut flere legemiddel 
   når reit = 0.
*/

abstract class Resept {
    // varibler
    static private int count = 0;
    protected int id;

    protected Legemiddel legemiddel;
    protected Lege lege;
    protected int pasientId;
    protected int reit;

    // Konstruktør
    public Resept(Legemiddel legemiddelet, Lege utskrivendeLege,
		  int pasientIden, int totResepterReit) {
	legemiddel = legemiddelet;
	lege = utskrivendeLege;
	pasientId = pasientIden;
	reit = totResepterReit;

	// Opprett unik id for Resept
	id = count++;
    }

    // Getters
    public int hentId() {
	return id;
    }

    public String hentLegemiddel() {
	return legemiddel.hentNavn();
    }

    public String hentLege() {
	return lege.hentNavn();
    }

    public int hentPasientId() {
	return pasientId;
    }

    public int hentReit() {
	return reit;
    }

    // Metode for å bruke resepten
    public boolean bruk() {
	if (reit <= 0) {
	    return false;
	} else {
	    reit--;
	    return true;
	}
    }

    // Prototype metoder, abstrakte metoder, tvinger barn
    // til å opprette disse metodene
    abstract public String farge();
    abstract public double prisAaBetale();

    // toString() metoden
    @Override
    public String toString() {
	return "Resept Id: " + hentId() + "\t- Legemiddel: " +
	    hentLegemiddel() + "\t- Utstedt av lege " + hentLege() +
	    "\n - Pasient Id: " + hentPasientId() +
	    "\t- Gjenværende resept uttak: " + hentReit();
    }
}
