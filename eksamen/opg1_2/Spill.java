/*
  --*java*--
  I oppgave 2 er det kun en spiller.
*/

class Spill {
    // Spiller instans
    Spiller spiller;

    // antall trekk spillet tar
    int trekk = 3;
    
    // Konstruktor
    public Spill(Spiller spiller) {
	this.spiller = spiller;
    }

    public void spill() {
	for (int i = 0; i < trekk; i++) {
	    spiller.nyttTrekk();
	}
	
    }
    // La spillet gaa til spillet er ferdig
    // returner resultatet til SpillKontroll

    public int formueResultat() {
	return spiller.oppgiFormue();
    }
}
