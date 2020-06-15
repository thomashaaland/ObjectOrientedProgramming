/*
  --*java*--
  Terreng oppretter en serie med Sted
  leser terrenget fra filen <<steder.txt>>
*/

// Imports
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

class Terreng {
    // Instanser 
    protected Sted start;
    protected Sted siste;
    protected int lengde;

    // Konstruktor
    // Oppretter en startposisjon og lenker sammen alle stedene
    public Terreng() {
	// Gi instansene verdier i tilfelle filen er tom
	start = null;
	siste = start;
	lengde = 0;
	
	// Opprett Scanner objekt som skal gaa gjennom steder.txt
	String stedsFil = "steder.txt";
	File fil = new File(stedsFil);
	Scanner fileScan = null;
	try {
	    fileScan = new Scanner(fil);
	}
	catch (FileNotFoundException e) {
	    System.out.println(e);
	}
	stedTildeling(fileScan);
	
	// Gjoer terrenget syklisk
	siste.leggTilRettFrem(start);
    }

    // Metode som returnerer startstedet
    public Sted hentStart() {
	// trekk et tilfeldig tall som skal avgjoere hva som blir start
	Random rand = new Random();
	int skift = rand.nextInt(lengde);
	// Sykle gjennom og skift hele rekken
	while (skift-- > 0) {
	    siste = siste.gaaRettFrem();
	    start = start.gaaRettFrem();
	}
	return start;
    }
    
    protected void stedTildeling(Scanner fileScan) {
    	// Begynn aa tildele beskrivelser til steder
	start = new Sted(fileScan.nextLine());
	siste = start;
	siste.plasserSkattkiste();
	lengde++;
	while (fileScan.hasNext()) {
	    siste.leggTilRettFrem(new Sted(fileScan.nextLine()));
	    siste = siste.gaaRettFrem();
	    siste.plasserSkattkiste();
	    lengde++;
	}
    }
}
