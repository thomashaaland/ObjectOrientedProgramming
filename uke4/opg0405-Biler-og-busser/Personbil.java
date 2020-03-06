class Personbil extends Bil {
    protected int antallSitteplasser;

    public Personbil(String regNr, String fabMerk, String eierNavn, int nSitt) {
	super(regNr, fabMerk, eierNavn);
	antallSitteplasser = nSitt;
    }

    public double beregnArsAvgift() {
	return 3000;
    }

    public void lesInnData(String regNr, String fabMerk, String eierNavn, int nSitt) {
	super.registreringsnummer = regNr;
	super.fabrikkmerke = fabMerk;
	eierensNavn = eierNavn;
	antallSitteplasser = nSitt;
    }

    public void skrivInfo() {
	System.out.println("Personbil med " + antallSitteplasser + " sitteplasser - Merke: " + fabrikkmerke);
	System.out.println("Eier: " + eierensNavn + " Registrerings nummer: " + registreringsnummer + ".");
	System.out.println("Årsavgiften er " + beregnArsAvgift());
    }
    
}
