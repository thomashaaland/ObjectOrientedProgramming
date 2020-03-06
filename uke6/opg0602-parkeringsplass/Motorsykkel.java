class Motorsykkel extends Kjoretoy {
    private int kubikk;

    public Motorsykkel(int regNr, int kub) {
	super(regNr);
	kubikk = kub;
    }

    public int hentAntallKubikk() {
	return kubikk;
    }
}
