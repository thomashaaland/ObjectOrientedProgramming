abstract class Rute {
    // Koordinater: (kolonne, rad)
    //private int[] koordinater;
    protected int kolonne;
    protected int rad;
    protected Labyrint labyrint;
    protected Rute nord;
    protected Rute syd;
    protected Rute ost;
    protected Rute vest;
    
    public Rute(int kolonne, int rad, Labyrint labyrint) {
	this.kolonne = kolonne;
	this.rad = rad;
	this.labyrint = labyrint;
    }

    public void leggTilNaboer(Rute nord, Rute syd, Rute ost, Rute vest) {
	this.nord = nord;
	this.syd = syd;
	this.ost = ost;
	this.vest = vest;
    }
	
    protected String koordinater() {
	return "(" + kolonne + ", " + rad + ")";
    }

    // Metode for å sjekke om ruten man sjekker har blitt sjekket før
    private boolean vaertHerFoer(Stabel<Rute> tilbakesporing) {
	for (Rute rute : tilbakesporing) {
	    if (labyrint.utskrift()) {
		System.out.println(rute.koordinater());
	    }
	    if (rute.koordinater().equals(koordinater())) {
		return true;
	    }
	}
	return false;
    }

    public void gaa(Stabel<Rute> tilbakespor, String rute) {
	Stabel<Rute> tilbakesporing = new Stabel<>();
	tilbakesporing.kopier(tilbakespor);
	tilbakesporing.leggPaa(this);

	if (this.erAapning()) {
	    // Skru på for debugging
	    if (labyrint.utskrift()) {
		System.out.println("Fant åpning: " + koordinater());
	    }
	    rute = rute + koordinater();
	    // Skru på denne for debugging
	    if (labyrint.utskrift()) {
		System.out.println("Ruten du fant var: " + rute);
	    }
	    labyrint.leggTilUtvei(rute, tilbakesporing);
	}
	else if (!this.erHvit()) {
	    ;
	}
	else {
	    // Turn this on, for debugging
	    if (labyrint.utskrift()) {
		System.out.println(koordinater());
	    }
	    if (!nord.vaertHerFoer(tilbakesporing)) nord.gaa(tilbakesporing, rute +
							     koordinater() + "-->");
	    
	    if (!vest.vaertHerFoer(tilbakesporing)) vest.gaa(tilbakesporing, rute +
							     koordinater() + "-->");
	    
	    if (!ost.vaertHerFoer(tilbakesporing)) ost.gaa(tilbakesporing, rute +
							   koordinater() + "-->");
	    
	    if (!syd.vaertHerFoer(tilbakesporing)) syd.gaa(tilbakesporing, rute +
							   koordinater() + "-->");
	}
    }

    protected abstract boolean erAapning();
    
    protected abstract boolean erHvit();
    
    public void finnUtvei() {
	gaa(new Stabel<Rute>(), "");
    }

    protected abstract char tilTegn();
}
