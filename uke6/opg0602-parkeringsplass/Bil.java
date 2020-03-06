class Bil extends Kjoretoy {
    private int antallPassasjerseter;

    public Bil(int regNr, int antPass) {
	super(regNr);
	antallPassasjerseter = antPass;
    }

    public int hentAntallPassasjerSeter() {
	return antallPassasjerseter;
    }
}
