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
    protected Pasient pasient;
    protected int reit;

    // Konstruktør
    public Resept(Legemiddel legemiddelet, Lege utskrivendeLege,
		  Pasient pasienten, int totResepterReit) {
	legemiddel = legemiddelet;
	lege = utskrivendeLege;
	pasient = pasienten;
	reit = totResepterReit;

	// Opprett unik id for Resept
	id = count++;
    }

    // Getters
    public int hentId() {
	return id;
    }

    public Legemiddel hentLegemiddel() {
	return legemiddel;
    }

    public String hentLege() {
	return lege.hentNavn();
    }

    public Pasient hentPasient() {
	return pasient;
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
	return String.format("\tID: %-5s-Legemiddel: %-20s- Utsteder: Dr. %s\n \t\t-%s \n\t\t-Gjenværende resept uttak: %s", hentId(), legemiddel.hentNavn(), hentLege(), hentPasient(), hentReit());

    }
}
