/*
  --*java*--
  I oppgave 2 er det kun en spiller.
*/

class Spill {
    // Spiller instans
    Spiller[] spillere;

    // antall trekk spillet tar
    int trekk = 3;
    
    // Konstruktor
    public Spill(Spiller[] spillere) {
	this.spillere = spillere;
    }

    // Spill loop
    public void spill() {
	// Ytterste loopen er spill runder
	for (int i = 0; i < trekk; i++) {
	    System.out.println("\nRUNDE " + i + "!");
	    System.out.println((trekk - i) + " runder igjen!");
	    // Neste loop gaar over alle spillere
	    for (int j = 0; j < spillere.length; j++) {
		System.out.println("\nDet er spiller " + (j + 1) + " sin tur.");
		spillere[j].nyttTrekk();
	    }
	}
	
    }
    // La spillet gaa til spillet er ferdig
    // returner resultatet til SpillKontroll

    public String formueResultat() {
	String resultat = "";
	for (int i = 0; i < spillere.length; i++) {
	    resultat += "Spiller " + (i + 1) + ": " + spillere[i].oppgiFormue() + "\n";
	}
	return resultat;
    }
}
