import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

class Labyrint {
    // Format kolonne, rad
    // Instans variabler
    private static int rader;
    private static int kolonner;
    private Rute[][] labyrint;
    private Stabel< String > utveier;
    private boolean detaljertUtskrift = false;
    
    // Konstruktør
    private Labyrint(Rute[][] labyrint) {
	this.labyrint = labyrint;
    }

    // Factory metode
    static public Labyrint lesFraFil(File fil) throws FileNotFoundException {
	String linje;
	Scanner sc = new Scanner(fil);

	rader = sc.nextInt();
	kolonner = sc.nextInt();
	Rute[][] labyrint = new Rute[kolonner][rader];

	Labyrint utLabyrint = new Labyrint(labyrint);
	
	sc.nextLine();

	// Iterer gjennom rader
	for (int r = 0; r < rader; r++) {
	    linje = sc.nextLine();
	    // Iterer gjennom kolonner
	    for (int k = 0; k < kolonner; k++) {
		// Oppretter ruter
		Rute rute = null;
		
		// Sjekk om ruten er hvit og om den er på en kant
		if (linje.charAt(k) == '.') {
		    if (r % (rader - 1) == 0 || k % (kolonner - 1) == 0) {
			rute = new Aapning(k, r, utLabyrint);
		    }
		    else {
			rute = new HvitRute(k, r, utLabyrint);
		    }
		}
		else {
		    rute = new SortRute(k, r, utLabyrint);
		}
		// Legg til ruten i labyrint
		labyrint[k][r] = rute;
	    }
	}
	// Legger til naboer
	// Iterer gjennom rader
	for (int r = 0; r < rader; r++) {
	    // Iterer gjennom kolonner
	    for (int k = 0; k < kolonner; k++) {
		Rute nord = null;
		Rute syd = null;
		Rute ost = null;
		Rute vest = null;
		if (r != 0) nord = labyrint[k][r - 1];
		if (r != rader - 1) syd = labyrint[k][r + 1];
		if (k != kolonner - 1) ost = labyrint[k + 1][r];
		if (k != 0) vest = labyrint[k - 1][r];
		labyrint[k][r].leggTilNaboer(nord, syd, ost, vest);
	    }
	}
	System.out.println("Labyrinten:\n");
	System.out.println(utLabyrint);
	
	return utLabyrint;
    }

    // Kall denne for å starte med å finne utvei fra lastet labyrint
    public Stabel<String> finnUtveiFra(int startKolonne, int startRad) {
	utveier = new Stabel<>();
	labyrint[startKolonne][startRad].finnUtvei();
	return utveier;
    }

    public void skrivUtLosningInfo() {
	System.out.println("Antall løsninger: " + utveier.stoerrelse());
	String kortestVei = utveier.hent(0);
	int kortestLengde = kortestVei.length();
	for (String utvei : utveier) {
	    if (utvei.length() < kortestLengde) {
	        kortestVei = utvei;
	        kortestLengde = utvei.length();
	    }
	}
	System.out.println("Kortest vei:\n" + kortestVei);
    }

    // Legg til på stabelen utveier
    public void leggTilUtvei(String utvei) {
	utveier.leggPaa(utvei);
    }

    // Skru på detaljert utskrift
    public void settUtskrift() {
	detaljertUtskrift = true;
    }

    public boolean utskrift() {
	return detaljertUtskrift;
    }

    // toString metode som returnerer en string
    // Bruk denne metoden for å skrive ut labyrinten
    public String toString() {
	String string = "";
	for (int r = 0; r < rader; r++) {
	    for (int k = 0; k < kolonner; k++) {
		string += labyrint[k][r].tilTegn();
	    }
	    string += "\n";
	}	
	return string;
    }
}
