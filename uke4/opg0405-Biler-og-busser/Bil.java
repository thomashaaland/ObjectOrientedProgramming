public abstract class Bil {
    protected String registreringsnummer;
    protected String fabrikkmerke;
    protected String eierensNavn;

    public Bil(String regNr, String fabMerk, String eierNavn) {
	registreringsnummer = regNr;
	fabrikkmerke = fabMerk;
	eierensNavn = eierNavn;
    }

    public abstract void skrivInfo();
    public abstract void lesInnData(String regNr, String fabMer, String eierNavn, int nSitt);
}
