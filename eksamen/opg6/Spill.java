/*
  --*java*--
  Stoetter flere spillere
*/

import java.util.concurrent.CountDownLatch;

class Spill {
    // Locks
    private CountDownLatch ferdigTeller;
    
    // Spiller instans
    Spiller[] spillere;

    // antall trekk spillet tar
    int trekk = 3;
    
    // Konstruktor
    public Spill(Spiller[] spillere) {
	this.spillere = spillere;
	ferdigTeller = new CountDownLatch(spillere.length * trekk);
    }

    // Spill loop
    public void spill() {
	// Start en ny traad for hver bruker. Maa bruke en countdown latch for aa vente
	// Kistene er det eneste som hver spiller kan modifisere, saa kistene trenger laaser
	for (Spiller spiller : spillere) {
	    // start ny traad
	    Runnable nyttSpill = new SpillTraad(spiller, trekk, ferdigTeller);
	    Thread spillTraad = new Thread(nyttSpill);
	    spillTraad.start();
	}
	try {
	    ferdigTeller.await();
	}
	catch (InterruptedException e) {
	    System.out.println(e);
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

class SpillTraad implements Runnable {
    private CountDownLatch ferdigTeller;
    Spiller spiller;
    int trekk;

    public SpillTraad(Spiller spiller, int trekk, CountDownLatch ferdigTeller) {
	this.spiller = spiller;
	this.trekk = trekk;
	this.ferdigTeller = ferdigTeller;
    }

    @Override
    public void run() {
	// Ytterste loopen er spill runder
	for (int i = 0; i < trekk; i++) {
	    System.out.println("\nRUNDE " + i + "!");
	    System.out.println((trekk - i) + " runder igjen!");
	    spiller.nyttTrekk();
	    ferdigTeller.countDown();
	}
    }
}
