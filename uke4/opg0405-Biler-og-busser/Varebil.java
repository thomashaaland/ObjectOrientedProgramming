class Varebil extends Bil {
    protected int maxVekt;

    public Varebil(String regNr, String fabMerk, String eierNavn, int maksVekt) {
	super(regNr, fabMerk, eierNavn);
	maxVekt = maksVekt;
    }

    public double beregnArsAvgift() {
	return 4 * maxVekt;
    }

    public void lesInnData(String regNr, String fabMerk, String eierNavn, int maksVekt) {
	registreringsnummer = regNr;
	fabrikkmerke = fabMerk;
	eierensNavn = eierNavn;
	maxVekt = maksVekt;
    }

    public void skrivInfo() {
	System.out.println("Varebil med maksimale lastevekt " + maxVekt + " kg - Merke: " + fabrikkmerke);
	System.out.println("Eier: " + eierensNavn + " Registrerings nummer: " + registreringsnummer + ".");
	System.out.println("Årsavgiften er " + beregnArsAvgift());
    }
}
