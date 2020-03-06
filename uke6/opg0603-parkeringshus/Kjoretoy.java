class Kjoretoy {
    protected int registreringsnummer;

    public Kjoretoy(int regnr) {
	registreringsnummer = regnr;
    }

    public int hentRegNr() {
	return registreringsnummer;
    }
}
