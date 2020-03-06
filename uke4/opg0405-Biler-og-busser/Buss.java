class Buss extends Bil {
    protected int antallSitteplasser;

    public Buss(String regNr, String fabMerk, String eierNavn, int nSitt) {
	super(regNr, fabMerk, eierNavn);
	antallSitteplasser = nSitt;
    }

    @Override
    public void lesInnData(String regNr, String fabMerk, String eierNavn, int nSitt) {
	super.registreringsnummer = regNr;
	super.fabrikkmerke = fabMerk;
	super.eierensNavn = eierNavn;
	antallSitteplasser = nSitt;
    }
    
    @Override
    public void skrivInfo() {
	System.out.println("Buss med " + antallSitteplasser + " antall sitteplasser - Merke: " + fabrikkmerke);
	System.out.println("Eier: " + eierensNavn + " Registrerings nummer: " + registreringsnummer);
    }
}
