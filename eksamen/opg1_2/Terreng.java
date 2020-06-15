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
    private Sted start;
    private Sted siste;
    private int lengde;

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

	// Begynn aa tildele beskrivelser til steder
	start = new Sted(fileScan.nextLine());
	siste = start;
	siste.plasserSkattkiste();
	lengde++;
	while (fileScan.hasNext()) {
	    siste.leggTilSted(new Sted(fileScan.nextLine()));
	    siste = siste.gaaVidere();
	    siste.plasserSkattkiste();
	    lengde++;
	}
    }

    // Metode som returnerer startstedet
    public Sted hentStart() {
	// trekk et tilfeldig tall som skal avgjoere hva som blir start
	Random rand = new Random();
	int skift = rand.nextInt(lengde);
	// Sykle gjennom og skift hele rekken
	while (skift-- > 0) {
	    siste.leggTilSted(start);
	    siste = siste.gaaVidere();
	    start = start.gaaVidere();
	}
	return start;
    }

    /*
    // Metode for aa opprette en gjenstandsListe
    private ArrayList<Gjenstand> opprettGjenstandsListe() {
	ArrayList<Gjenstand> gjenstandsListe = new ArrayList<>();
	String filNavn = "gjenstander.txt";
	File fil = new File(filNavn);
	Scanner sc = null;
	try {
	    sc = new Scanner(fil);
	}
	catch (FileNotFoundException e) {
	    System.out.println(e);
	}

	while (sc.hasNext()) {
	    String[] line = sc.nextLine().split(" ");
	    String navn = line[0];
	    int verdi = Integer.parseInt(line[1]);
	    Gjenstand gjenstand = new Gjenstand(navn, verdi);
	    gjenstandsListe.add(gjenstand);
	}
	return gjenstandsListe;
    }
*/    

}
