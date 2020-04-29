/**
   Legesystem. Skal kunne lese inn info fra fil. 
   Leser inn fil, men trenger å tenke på hvordan vi skal gå fram, 
   Vi trenger å pakke informasjonen på en god måte. Feks
   for å lage resepter må vi gå via Lege.skrivResept()
   Gir mest mening å gå via hashmap, men vi må vel bruke LinkeListe
   eller sortertLinkeListe. Blir mye 
   if ()
   else if ()
   else
   osv.
 **/

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Legesystem {
    Lenkeliste<Pasient> pasienter = new Lenkeliste<>();
    Lenkeliste<Legemiddel> legemidler = new Lenkeliste<>();
    SortertLenkeliste<Lege> leger = new SortertLenkeliste<>();
    Lenkeliste<Resept> resepter = new Lenkeliste<>();

    // Hjelpemetode for å finne lege.
    public Lege finnLege(String legensNavn) {
	Iterator<Lege> iterator = leger.iterator();
	Lege lege;
	Lege riktigLege = null;
	while (iterator.hasNext()) {
	    lege = iterator.next();
	    if (lege.hentNavn().trim().equals(legensNavn.trim())) {
		riktigLege = lege;
		break;
	    }
	}
	return riktigLege;
    }

    // Finner pasient basert på ID
    public Pasient finnPasient(int pasientID) {
	Iterator<Pasient> iterator = pasienter.iterator();
	Pasient pasient;
	Pasient riktigPasient = null;
	while (iterator.hasNext()) {
	    pasient = iterator.next();
	    if (pasient.hentID() == pasientID) {
		riktigPasient = pasient;
		break;
	    }
	}
	return riktigPasient;
    }

    // Finner pasient basert på Navn
    public Pasient finnPasient(String navn) {
	Iterator<Pasient> iterator = pasienter.iterator();
	Pasient pasient;
	Pasient riktigPasient = null;
	while (iterator.hasNext()) {
	    pasient = iterator.next();
	    if (pasient.hentNavn() == navn) {
		riktigPasient = pasient;
		break;
	    }
	}
	return riktigPasient;
    }

    // Finner legemiddel basert på legemiddelID
    public Legemiddel finnLegemiddel(int legemiddelNr) {
	Iterator<Legemiddel> iterator = legemidler.iterator();
	Legemiddel legemiddel;
	Legemiddel riktigLegemiddel = null;
	while (iterator.hasNext()) {
	    legemiddel = iterator.next();
	    if (legemiddel.hentID() == legemiddelNr) {
		riktigLegemiddel = legemiddel;
		break;
	    }
	}
	return riktigLegemiddel;
    }

    
    // Hjelpemetode for å legge til pasient
    public void leggTilPasient(String line) {
	String[] linesplit = line.split(",");
	String navn = linesplit[0];
	String personNr = linesplit[1];
	pasienter.leggTil(new Pasient(navn, personNr));
    }
    
    // Hjelpemetode for å legge til legemiddel
    // Tar inn en string med formattering
    // (navn,type,pris,virkestoff,[styrke])
    public void leggTilLegemiddel(String line)
	throws IllegalArgumentException, IndexOutOfBoundsException {
	String[] linesplit = line.split(",");
	
	// Setter opp variabler
	String navn = linesplit[0];
	String type = linesplit[1];
	double pris = Double.valueOf(linesplit[2]);
	int virkestoff = Integer.valueOf(linesplit[3]);

	// Hvordan gjøre denne sjekken? Blir tvunget til å initialisere
	int styrke = -1;
	if (!type.equals("vanlig")) {
	    try { styrke = Integer.valueOf(linesplit[4]); }
	    catch (IndexOutOfBoundsException e) { e.printStackTrace(); }
	}

	// Legger til
	if (type.equals("narkotisk")) {
	    legemidler.leggTil(new Narkotisk(navn, pris, virkestoff, styrke));
	}
	else if (type.equals("vanedannende")) {
	    legemidler.leggTil(new Vanedannende(navn, pris, virkestoff, styrke));
	}
	else if (type.equals("vanlig")) {
	    legemidler.leggTil(new Vanlig(navn, pris, virkestoff));
	}
	else { throw new IllegalArgumentException("Gyldig legemiddeltyper er narkotisk, vanedannende og vanlig."); }
    }

    // Hjelpemetode for å legge til lege
    public void leggTilLege(String line) {
	String[] linesplit = line.split(",");
	int kontrollID = Integer.valueOf(linesplit[1]);
	// Lager legenavn
	String[] tempNavn = linesplit[0].split(" ", 0);
	String navn = "";
	for (int i = 1; i < tempNavn.length; i++) {
	    navn = navn + tempNavn[i] + " ";
	}
	
	if (kontrollID == 0) {
	    leger.leggTil(new Lege(navn));
	}
	else {
	    leger.leggTil(new Spesialist(navn, kontrollID));
	}
    }
    
    // Hjelpemetode for å legge til resept
    public void leggTilResept(String line) throws IllegalArgumentException, UlovligUtskrift {
	// Loop gjennom alle leger, finn riktig lege og bruk denne til å lage riktig resept
	// må også gå gjennom alle pasienter for å finne riktig pasient. 
	// -> riktigLege.skrivResept(legemiddel, pasienter.hent(id), reit);
	String[] linesplit = line.split(",");
	Resept nyResept;
	
	int legemiddelNr = Integer.valueOf(linesplit[0]);
	// Lager legenavn
	String[] tempNavn = linesplit[1].split(" ", 0);
	String legeNavn = "";
	for (int i = 1; i < tempNavn.length; i++) {
	    legeNavn = legeNavn + tempNavn[i] + " ";
	}

	int pasientID = Integer.valueOf(linesplit[2]);
	String resept = linesplit[3];
	int reit;
	if ( !resept.equals("p") ) { reit = Integer.valueOf(linesplit[4]); }
	else { reit = -1; }
	
	// Finn riktig lege
	Lege riktigLege = finnLege(legeNavn);
	Pasient riktigPasient = finnPasient(pasientID);
	Legemiddel riktigLegemiddel = finnLegemiddel(legemiddelNr);
	
	// Skriv ut riktig resept
	if (resept.equals("hvit")) {
	    nyResept = riktigLege.skrivHvitResept(riktigLegemiddel, riktigPasient, reit);
	}
	else if (resept.equals("blaa")) {
	    nyResept = riktigLege.skrivBlaaResept(riktigLegemiddel, riktigPasient, reit);
	    
	}
	else if (resept.equals("millitaer")) {
	    nyResept = riktigLege.skrivMillitaerResept(riktigLegemiddel, riktigPasient, reit);
	}
	else if (resept.equals("p")) {
	    nyResept = riktigLege.skrivPResept(riktigLegemiddel, riktigPasient);
	}
	else { throw new IllegalArgumentException("Kan kun skrive ut hvit, blaa, millitaer og p resept."); }
	riktigPasient.nyResept(nyResept);
	resepter.leggTil(nyResept);
    }
    
    public void lesFraFil(String filnavn) {
	File file = new File(filnavn);

	// Les inn fil og sorter info. Bruker mye nested if tester.
	// Finnes det en bedre måte? Dette blir fort veldig uoversiktlig.
	System.out.println("Leser inn fra filen " + filnavn);
	try (Scanner sc = new Scanner(file)) {
	    String line;
	    String[] linesplit;
	    String operation = "";
	    int i = 0;

	    // Les inn linje for linje
	    while (sc.hasNextLine()) {
		line = sc.nextLine();

		// Sjekk om vi skal bytte hva vi skal skrive om ved å se etter (char) '#'
		if (line.charAt(0) == '#') {
		    operation = line.split(" ")[1];
		    i = 0;
		}
		else {
		    // Dersom vi skal skrive inn pasienter
		    if (operation.equals("Pasienter")) {
			leggTilPasient(line);
		    }
		    // Dersom vi skal skrive inn legemidler
		    else if (operation.equals("Legemidler")) {
			leggTilLegemiddel(line);
		    }
		    // Dersom vi skal skrive inn leger
		    else if (operation.equals("Leger")) {
			leggTilLege(line);
		    }
		    // Dersom vi skal skrive inn resepter
		    else if (operation.equals("Resepter")) {
			try { leggTilResept(line); }
			catch ( UlovligUtskrift e ) {
			    e.printStackTrace();
			}
		    }
		}
	    }
	    sc.close();
	}
	catch (IOException e) {
	    e.printStackTrace();
	}

	System.out.println("Lest inn data vellykket");
    }

    // For å skrive ut lister:
    public void skrivPasientliste() {
	Iterator<Pasient> iterator = pasienter.iterator();
	int i = 0;
	while (iterator.hasNext()) {
	    System.out.println(i++ + ": " + iterator.next());
	}
    }

    public void skrivLegemiddelliste() {
	Iterator<Legemiddel> iterator = legemidler.iterator();
	int i = 0;
	while (iterator.hasNext()) {
	    System.out.println(i++ + ": " + iterator.next());
	}
    }

    public void skrivLegeliste() {
	Iterator<Lege> iterator = leger.iterator();
	int i = 0;
	while (iterator.hasNext()) {
	    System.out.println(i++ + ": " + iterator.next());
	}
    }

    public void skrivReseptliste() {
	Iterator<Resept> iterator = resepter.iterator();
	int i = 0;
	while (iterator.hasNext()) {
	    System.out.println(i++ + ": " + iterator.next());
	}
    }

    // Statistikkdel
    // Teller opp totale antall vanedannende legemidler som er blitt skrevet ut

    private int totVanedannende() {
	int vaneNum = 0;
	Lenkeliste<Resept> utskrevedeResepter;
	Iterator<Lege> legeIt = leger.iterator();
	while (legeIt.hasNext()) {
	    utskrevedeResepter = legeIt.next().hentResepter();
	    Iterator<Resept> reseptIt = utskrevedeResepter.iterator();
	    while(reseptIt.hasNext()) {
		if (reseptIt.next().hentLegemiddel() instanceof Vanedannende) { vaneNum++; }
	    }
	}
	return vaneNum;
    }

    // Teller opp totale antall narkotiske legemidler som er blitt skrevet ut
    private int totNarkotisk() {
	int narkoNum = 0;
	Lenkeliste<Resept> utskrevedeResepter;
	Iterator<Lege> legeIt = leger.iterator();
	Legemiddel legemiddel;
	while (legeIt.hasNext()) {
	    utskrevedeResepter = legeIt.next().hentResepter();
	    Iterator<Resept> reseptIt = utskrevedeResepter.iterator();
	    while(reseptIt.hasNext()) {
		if (reseptIt.next().hentLegemiddel() instanceof Narkotisk) { narkoNum++; }
	    }
	}
	return narkoNum;
    }

    // Skal liste opp alle leger som har skrevet ut narkotiske midler
    // og hvor mange slike midler denne legen har skrevet ut
    // Flere av metodene bruker liknende kode. Burde kunne effektiviseres.
    private String sjekkMisbrukLege() {
	Iterator<Lege> legeIt = leger.iterator();
	int narko;
	String out = "";
	while (legeIt.hasNext()) {
	    Lege denneLege = legeIt.next();
	    Iterator<Resept> reseptIt = denneLege.hentResepter().iterator();
	    narko = 0;
	    while(reseptIt.hasNext()) {
		if (reseptIt.next().hentLegemiddel() instanceof Narkotisk) { narko++; }
	    }
	    if (narko >= 1) {
		out = out +
		    "Dr. " + denneLege.hentNavn() + " -Narkotiske resepter: " + narko + "\n";	    
	    }
	}
	
	return out;
    }

    // Skal liste opp alle pasienter som har fått narkotiske midler
    // og hvor mange slike midler som er blitt skrevet ut
    private String sjekkMisbrukPasient() {
	Iterator<Pasient> pasientIt = pasienter.iterator();
	int narko;
	String out = "";
	while (pasientIt.hasNext()) {
	    Pasient dennePasient = pasientIt.next();
	    Iterator<Resept> reseptIt = dennePasient.hentReseptListe().iterator();
	    narko = 0;
	    while (reseptIt.hasNext()) {
		if (reseptIt.next().hentLegemiddel() instanceof Narkotisk) { narko++; }
	    }
	    if (narko >= 1) {
		out = out +
		    dennePasient.hentNavn() + " -Narkotiske resepter: " + narko + "\n";
	    }
	}
	return out;
    }
    
    public void visStatistikk() {
	System.out.println(String.format("Utskrevne vanedannende resepter: %s",
					 totVanedannende()));
	System.out.println(String.format("Utskrevne narkotiske resepter: %s",
					 totNarkotisk()));
	System.out.print("Leger som har skrevet ut narkotiske:\n" +
			 sjekkMisbrukLege());
	System.out.print("Pasienter som har fått narkotiske:\n" +
			 sjekkMisbrukPasient());
    }

    public void skrivTilFil(String outFile) {
	PrintWriter utFil = null;
	try {
	    utFil = new PrintWriter(outFile);
	    // Doing stuff
	    Legemiddel legemiddel;
	    Resept resept;
	    Lege lege;
	    Pasient pasient;
	    
	    System.out.println("\nSkriver til filen " + outFile);
	    
	    // Skriv ut pasienter
	    utFil.println("# Pasienter (navn, fnr)");
	    Iterator<Pasient> pasientIt = pasienter.iterator();
	    while (pasientIt.hasNext()) {
		pasient = pasientIt.next();
		utFil.println(pasient.hentNavn() + "," + pasient.hentPersnum());
	    }
	    
	    // Skriv ut legemidler
	    utFil.println("# Legemidler (navn,type,pris,virkestoff,[styrke])");
	    Iterator<Legemiddel> legemiddelIt = legemidler.iterator();
	    String navn;
	    String type;
	    int pris;
	    int virkestoff;
	    int styrke;
	    while (legemiddelIt.hasNext()) {
		legemiddel = legemiddelIt.next();
		navn = legemiddel.hentNavn();
		pris = (int) legemiddel.hentPris();
		virkestoff = (int) legemiddel.hentVirkestoff();
		if (legemiddel instanceof Vanlig) {
		    type = "vanlig";
		    utFil.println(navn + "," + type + "," + pris + "," + virkestoff);
		}
		else if (legemiddel instanceof Vanedannende) {
		    Vanedannende vanedannende = (Vanedannende) legemiddel;
		    type = "vanedannende";
		    styrke = (int) vanedannende.hentVanedannendeStyrke();
		    utFil.println(navn + "," + type + "," + pris + "," + virkestoff +
				  "," + styrke);
		}
		else if (legemiddel instanceof Narkotisk) {
		    Narkotisk narkotisk = (Narkotisk) legemiddel;
		    type = "narkotisk";
		    styrke = (int) narkotisk.hentNarkotiskStyrke();
		    utFil.println(navn + "," + type + "," + pris + "," + virkestoff +
				  "," + styrke);
		} // Exception her? Dersom legemiddelkategori ikke gjenkjennes?
		
	    }
	    
	    // Skriv ut Leger
	    utFil.println("# Leger (navn,kontrollid / 0 hvis vanlig lege)");
	    Iterator<Lege> legeIt = leger.iterator();
	    while (legeIt.hasNext()) {
		lege = legeIt.next();
		if (lege instanceof Spesialist) {
		    Spesialist spesialist = (Spesialist) lege;
		    utFil.println("Dr. " + spesialist.hentNavn() +
				  "," + spesialist.hentKontrollID());
		}
		else {
		    utFil.println("Dr. " + lege.hentNavn() + ",0");
		}
	    }
	    
	    // Skriv ut resepter
	    utFil.println("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])");
	    Iterator<Resept> reseptIt = resepter.iterator();
	    String legeNavn;
	    while (reseptIt.hasNext()) {
		resept = reseptIt.next();
		legemiddel = resept.hentLegemiddel();
		legeNavn = resept.hentLege();
		pasient = resept.hentPasient();

		if (resept instanceof Presept) {
		    utFil.println(legemiddel.hentID() + ",Dr. " + legeNavn + "," +
				  pasient.hentID() + ",p,");
		}
		else if (resept instanceof Militaerresept) {
		    utFil.println(legemiddel.hentID() + ",Dr. " + legeNavn + "," +
				  pasient.hentID() + ",millitaer," + resept.hentReit());
		}
		else if (resept instanceof Blaaresept) {
		    utFil.println(legemiddel.hentID() + ",Dr. " + legeNavn + "," +
				  pasient.hentID() + ",blaa," + resept.hentReit());
		}
		else if (resept instanceof Hvitresept) {
		    utFil.println(legemiddel.hentID() + ",Dr. " + legeNavn + "," +
				  pasient.hentID() + ",hvit," + resept.hentReit());
		} // Throw exception here? What happend if resept is not recognized?
	    }
	}
	catch (IOException e) {
	    System.out.println("Fant ikke filen " + outFile);
	}
	finally {
	    if (utFil != null) {
		try {
		    utFil.close();
		    System.out.println("Ferdig skrevet til filen " + outFile);
		}
		catch (Exception e) {
		    System.out.println("Fikk ikke lukket filen " + outFile);
		}
	    }
	}
    }
}
