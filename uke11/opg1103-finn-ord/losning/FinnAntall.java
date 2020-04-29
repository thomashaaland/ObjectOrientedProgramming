import java.util.concurrent.CountDownLatch;
import java.util.Scanner;
import java.io.File;

class FinnAntall {
    public static void main(String[] args) {

	// Henter argumenter fra terminal
	String ordSomSkalFinnes = args[0];
	String filnavn = args[1];
	int antallTraader = Integer.parseInt(args[2]);

	// Leser fra fil
	Scanner fil = null;
	try {
	    fil = new Scanner(new File(filnavn));
	}
	catch(Exception e) {
	    System.out.println(e);
	}

	int antallLinjer = fil.nextInt();
	fil.nextLine();

	String[] listeOrd = new String[antallLinjer];

	int indeks = 0;
	while (fil.hasNextLine()) {
	    String ord = fil.nextLine();
	    listeOrd[indeks] = ord;
	    indeks++;
	}

	// Hver tråd trenger en referanse til en CountDownLath og en monitor
	CountDownLatch count = new CountDownLatch(antallTraader);
	OrdMonitor monitor = new OrdMonitor();
	int ordPaaHverTraad = antallLinjer / antallTraader;
	indeks = 0;

	// deler opp listen med ord og oppretter trådene
	for (int i = 0; i < antallTraader; i++) {

	    // Hvor mange ord skal tråden lete etter?
	    int antallOrd;
	    if (i == antallTraader - 1) antallOrd = antallLinjer;
	    else antallOrd = ordPaaHverTraad;

	    // finner start og sluttindeks for den enkelte tråden
	    int startIndeks = indeks;
	    int sluttIndeks = indeks + antallOrd;
	    indeks += antallOrd; //***//

	    OrdFinner o = new OrdFinner(listeOrd, startIndeks, sluttIndeks, ordSomSkalFinnes, monitor, count);
	    Thread t = new Thread(o);
	    t.start();
	}

	// Etter at alle trådene er opprettet må main-tråden vente på at alle blir ferdige
	try {
	    count.await();
	}
	catch (InterruptedException e) {
	    System.out.println(e);
	}

	System.out.println("Ordet forekom " + monitor.hentAntall() + " ganger i filen.");
    }
}
