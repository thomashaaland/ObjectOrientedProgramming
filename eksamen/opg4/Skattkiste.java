/*
  --*java*--
  Metoden skattkiste skal kunne ha et visst antall
  Gjenstander i seg. Konstruktoren danner et visst 
  antall, etter det maa spiller kunne trekke en gjenstand
  eller legge en gjenstand i kisten. Kisten vil da 
  ta vare paa denne gjenstanden
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class Skattkiste {
    // gjenstandsListe er listen over mulige gjenstander aa velge mellom
    private static ArrayList<Gjenstand> gjenstandsListe = opprettGjenstandsListe();

    // gjenstander er listen over hvilke gjenstander denne kisten inneholder
    private ArrayList<Gjenstand> gjenstander = new ArrayList<Gjenstand>();
    private int kapasitet;

    // Konstruktor
    // Kisten maa faa vite hvor stor den er. Ellers fylles den opp paa egenhaand
    public Skattkiste(int kapasitet) {
	Random rand = new Random();
	this.kapasitet = kapasitet;
	int antGjenstander = 0;
	if (kapasitet > 0) {
	    antGjenstander = rand.nextInt(kapasitet);
	}
	for (int i = 0; i < antGjenstander; i++) {
	    gjenstander.add(gjenstandsListe.get(rand.nextInt(gjenstandsListe.size())));
	}
	
    }

    // Bruk denne konstruktoren dersom dette er en ryggsekk
    public Skattkiste(int kapasitet, String ryggsekk) {
	this.kapasitet = kapasitet;
    }

    public Gjenstand taUt() {
	if (gjenstander.size() == 0) {
	    return null;
	}
	else {
	    // Tar ut en tilfeldig gjenstand
	    Random rand = new Random();
	    return gjenstander.remove(rand.nextInt(gjenstander.size()));
	}
    }

    // gi tilbake en pris. Spilleren "Selger" gjenstanden
    // Prisen må varieres og trekkes litt tilfeldig
    public int leggI(Gjenstand gjenstand) {
	if (gjenstander.size() < kapasitet) {
	    // Legger i valgt gjenstant
	    gjenstander.add(gjenstand);
	    return gjenstand.verdi();
	}
	else {
	    return 0;
	}
    }

    public int size() {
	return gjenstander.size();
    }

    public boolean erTom() {
	return (gjenstander.size() == 0);
    }

    public boolean harPlass() {
	return (gjenstander.size() < kapasitet);
    }

        // Metode for aa opprette en gjenstandsListe
    private static ArrayList<Gjenstand> opprettGjenstandsListe() {
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
    
}
