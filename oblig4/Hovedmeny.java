import java.util.*;
import java.io.*;

class Hovedmeny{
    // Initier variabler:
    String meny = "________________________________________________________________________\n" +
	"|                                                                      |\n" +
	"|                                                                      |\n" +
	"|                       Velkommen til legesystemet                     |\n" +
	"|                                                                      |\n" +
	"|                               Hovedmeny:                             |\n" +
	"|                                                                      |\n" +
	"|______________________________________________________________________|\n" +
	"| 0: Hjelp:____________________________________________________________|\n" +
	"| 1: Skrive ut fullstendig oversikt over pasienter, leger,             |\n" +
	"|    Legemidler og resepter:___________________________________________|\n" +
	"| 2: Opprette og legge til nye elementer i systemet:___________________|\n" +
	"| 3: Bruke en gitt resept fra listen til en pasient:___________________|\n" +
	"| 4: Skrive ut forskjellige former for statistikk:_____________________|\n" +
	"| 5: Skrive alle data til fil:_________________________________________|\n" +
	"| 6: Avslutte programmet_______________________________________________|\n" +
	"|______________________________________________________________________|\n";

    Legesystem legesystem;
    String lagringsSted;

    // Hjelpemetode for å kreve int svar
    private int faaIntSvar() {
	Scanner scanner = new Scanner(System.in);
	try {
	    return scanner.nextInt();
	} catch (InputMismatchException e) {
	    System.out.println("Feil input: Trenger et tall");
	    System.out.print("> ");
	    return faaIntSvar();
	}
    }

    // Henter int, har rom for long, stiller krav til antall siffer
    // Dersom siffer = -1  er kravet ikke tatt med
    private String hentIntString(int siffer) {
	Scanner scanner = new Scanner(System.in);
	String fNr;
	fNr = scanner.nextLine();
	System.out.println(fNr);
	try {
	    long number = Long.parseLong(fNr);
	}
	catch (NumberFormatException e) {
	    System.out.println("Tast kun inn tall.");
	    System.out.print("> ");
	    return hentIntString(siffer);
	}
	try {
	    if (fNr.length() != siffer && siffer != -1) {
		System.out.println("Må ha " + siffer + " siffer");
		System.out.print("> ");
		hentIntString(siffer);
	    }
	}
	catch (NumberFormatException e) {
	    System.out.println("Trenger " + siffer + " siffer");
	    System.out.print("> ");
	    hentIntString(siffer);
	}
	return fNr;
    }

    private String hentLegemiddelType() {
	String type;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Velg type på legemiddel:\n" +
			   "1: vanlig\n" +
			   "2: vanedannende\n" +
			   "3: narkotisk");
	System.out.print("> ");
	int valg = Integer.parseInt(hentIntString(1));
	switch (valg) {
	case 1:
	    type = "vanlig";
	    break;
	case 2:
	    type = "vanedannende";
	    break;
	case 3:
	    type = "narkotisk";
	    break;
	default:
	    System.out.println("Ugyldig valg");
	    type = hentLegemiddelType();
	    break;
	}
	return type;
    }
    
    private String hentReseptType() {
	String type;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Velg type på resept:\n" +
			   "1: hvit\n" +
			   "2: millitær\n" +
			   "3: p-resept\n" +
			   "4: blå");
	System.out.print("> ");
	int valg = Integer.parseInt(hentIntString(1));
	switch (valg) {
	case 1:
	    type = "hvit";
	    break;
	case 2:
	    type = "millitaer";
	    break;
	case 3:
	    type = "presept";
	    break;
	case 4:
	    type = "blaa";
	    break;
	default:
	    System.out.println("Ugyldig valg");
	    type = hentLegemiddelType();
	    break;
	}
	return type;
    }

    private String hentKontrollID() {
	String kontrollID;
	String velgLegeSpesialist;
	System.out.println("Velg lege eller spesialist:\n" +
			   "1: Lege\n" +
			   "2: Spesialist");
	System.out.print("> ");
	velgLegeSpesialist = hentIntString(-1);
	if (velgLegeSpesialist.equals("1")) {
	    kontrollID = "0";
	}
	else if (velgLegeSpesialist.equals("2")) {
	    System.out.print("Skriv inn kontrollID, 5 siffer: ");
	    System.out.print("> ");
	    kontrollID = hentIntString(5);
	}
	else {
	    System.out.println("Du må velge 1 eller 2.");
	    kontrollID = hentKontrollID();
	}
	return kontrollID;
    }
	
    
    // MENY VALG
    // Menyvalg skrivListe (1)
    private void skrivListe() {
	System.out.println("Velg data å skrive ut:\n" +
			   "1: Legeliste\n" +
			   "2: Legemiddelliste\n" +
			   "3: Reseptliste\n" +
			   "4: Pasientliste\n");
	System.out.print("> ");
	int svar;
	svar = faaIntSvar();

	switch (svar)
	    {
	    case 1:
		//sortert liste med leger
		System.out.println("\n #### LEGELISTE ####");
		legesystem.skrivLegeliste();
		break;
	    case 2:
		//legemidler
		System.out.println("\n ####  LEGEMIDDELLISTE ####");
		legesystem.skrivLegemiddelliste();
		break;
	    case 3:
		//resepter
		System.out.println("\n #### RESEPTLISTE ###");
		legesystem.skrivReseptliste();
		break;
	    case 4:
		//pasienter
		System.out.println("\n ### PASIENTLISTE ####");
		legesystem.skrivPasientliste();
		break;
	    default:
		System.out.println("Ikke gyldig valg.");
		break;
	    }
    }
	
    // Menyvalg (2)
    private void leggeTilElementer() {
	// Generelle deklarasjoner:
	int svar;
	String line;
	Scanner scanner = new Scanner(System.in);

	// Deklarasjoner for Pasient
	String navn;
	int sifferFodselsnummer;
	String fdslsnr;

	// Deklarasjoner for legemiddel
	String legemiddelnavn;
	String type;
	String pris;
	String virkestoffkode;
	String styrke;

	// Deklarasjoner for lege
	String kontrollID;
	
	System.out.println("Vil du legge til\n" +
			   "1: Pasient\n" +
			   "2: Legemiddel\n" +
			   "3: Lege\n" +
			   "4: Resept\n");
	System.out.print("> ");
	svar = faaIntSvar();

	// Start switch
	switch(svar) {
	case 1:
	    // Legge til:
	    // Formatering:
	    // # Pasienter (navn, fnr)
	    // Jens Hans Olsen,11111143521
	    System.out.println("Skriv inn navn:");
	    System.out.print("> ");
	    navn = scanner.nextLine();
	    
	    System.out.println("Skriv inn fødselsnummer:");
	    System.out.print("> ");
	    sifferFodselsnummer = 11;
	    fdslsnr = hentIntString(sifferFodselsnummer);
	    
	    line = navn + "," + fdslsnr;
	    
	    legesystem.leggTilPasient(line);
	    break;
	case 2:
	    // # Legemidler (navn,type,pris,virkestoff,[styrke])
	    // Predizol,narkotisk,450,75,8
	    System.out.println("Skriv inn navn på legemiddel:");
	    System.out.print("> ");
	    legemiddelnavn = scanner.nextLine();

	    // Henter legemiddeltype
	    type = hentLegemiddelType();

	    // Henter pris
	    System.out.println("Skriv inn pris:");
	    System.out.print("> ");
	    pris = hentIntString(-1);
	    
	    // Henter virkestoffkode
	    System.out.println("Skriv inn virkestoffkode:");
	    System.out.print("> ");
	    virkestoffkode = hentIntString(-1);

	    // Lag data som skal sendes til legesystem
	    line = legemiddelnavn + "," + type + "," + pris + "," + virkestoffkode;
	    
	    if (!type.equals("vanlig")) {
		System.out.println("Skriv inn styrke på legemiddel");
		System.out.print("> ");
		styrke = hentIntString(-1);
		line += "," + styrke;
	    }
	    
	    legesystem.leggTilLegemiddel(line);
	    break;
	case 3:
	    // # Leger (navn,kontrollid / 0 hvis vanlig lege)
	    // Dr. Cox,0
	    System.out.println("Skriv navn på lege");
	    System.out.print("> ");
	    navn = scanner.nextLine();

	    kontrollID = hentKontrollID();

	    line = "Dr. " + navn + "," + kontrollID;
	    	    
	    legesystem.leggTilLege(line);
	    break;
	case 4:
	    // # Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])
	    // 1,Dr. Cox,2,hvit,7
	    //legesystem.leggTilResept(line);
	    legesystem.skrivLegemiddelliste();
	    System.out.println("Velg legemiddel ved legemiddelID: ");
	    System.out.print("> ");
	    int valg = Integer.parseInt(hentIntString(-1));
	    Legemiddel legemiddel = legesystem.finnLegemiddel(valg);
	    if (legemiddel == null) {
		System.out.println("Fant ikke legemiddelet");
		break;
	    }
	    int legemiddelID = legemiddel.hentID();
	    
	    legesystem.skrivLegeliste();
	    System.out.println("Velg lege (Velg ved å skrive inn navn uten tittel):");
	    System.out.print("> ");
	    String legeNavn = scanner.nextLine();
	    System.out.println(legeNavn);
	    if (legesystem.finnLege(legeNavn) == null) {
		System.out.println("Fant ikke legen.");
		break;
	    }
	    
	    legesystem.skrivPasientliste();
	    System.out.println("Velg pasient ved pasient ID: ");
	    System.out.print("> ");
	    int pasientID = Integer.parseInt(hentIntString(-1));
	    if (legesystem.finnPasient(pasientID) == null) {
		System.out.println("Fant ikke pasient");
		break;
	    }

	    System.out.println("Velg resept type:");
	    type = hentReseptType();

	    line = legemiddelID + ",Dr. " + legeNavn + "," + pasientID + "," + type;
	    if (!type.equals("millitaer")) {
		System.out.println("Skriv inn antall reit: ");
		System.out.print("> ");
	        line += "," + hentIntString(-1);
	    }
	    try { legesystem.leggTilResept(line); }
	    catch ( UlovligUtskrift e ) {
		e.printStackTrace();
	    }
		
	    break;
	default:
	    System.out.println("Ugyldig valg");
	}
    }
    /** 
	Først kan bruker enten taste inn integers eller en string, 
	for å søke opp riktig pasient. Først sjekkes det om input er 
	int, string eller en kombinasjon. Hvis det er int eller string, 
	brukes det for å kalle på en av finnPasient-metodene. De har 
	lik signatur bortsett fra at en tar int og en tar string. Hvis 
	ikke riktig pasient blir funnet, returners det til hovedmenyen. 
	Hvis så riktig pasient er funnet, brukes den for å hente 
	reseptliste. Hvis det finnes en reseptliste, kan bruker taste 
			inn hvilken resept som skal brukes, som så brukes.
    **/
    // Bruke resept (3)
    private void brukResept() {
	legesystem.skrivPasientliste();
	System.out.println("Velg pasient ved pasient ID: ");
	System.out.print("> ");
	int pasientID = Integer.parseInt(hentIntString(-1));
	Pasient pasient = legesystem.finnPasient(pasientID);
	if (pasient == null) {
	    System.out.println("Fant ikke pasient");
	    hovedmeny();
	}
	// Skriv reseptListe:
	System.out.println(pasient);
	Stabel<Resept> reseptListe = pasient.hentReseptListe();
	Iterator<Resept> iterator = reseptListe.iterator();
	int i = 0;
	while (iterator.hasNext()) {
	    Resept resept = iterator.next();
	    if (resept instanceof Militaerresept) {
		System.out.println(i++ + ": " + resept.hentLegemiddel().hentNavn());
	    }
	    else {
		System.out.println(i++ + ": " + resept.hentLegemiddel().hentNavn() +
			       " (reit: " + resept.hentReit() + ")");
	    }
	}

	// bruk resept:
	if (reseptListe.stoerrelse() == 0) {
	    System.out.println("Denne pasienten har ingen resepter.");
	}
	else {
	    System.out.println("Velg en resept å bruke");
	    System.out.print("> ");
	    try {
		Scanner scanner = new Scanner(System.in);
		int get = scanner.nextInt();
		if (get < 0) {
		    System.out.println("Indeksen må være 0 eller større");
		}
		else if (get >= reseptListe.stoerrelse()) {
		    System.out.println("Indeksen må være mindre enn " + reseptListe.stoerrelse());
		}
		else {
		    if ( reseptListe.hent(get).bruk() ) {
			System.out.println("Brukte en resept");
		    }
		    else {
			System.out.println("Tom for resepter.");
		    }
		}
	    }
	    catch (NumberFormatException e) {
		hovedmeny();
	    }
	}
    }

    private int avslutt() {
    //ber om input fra bruker om data skal lagres
	Scanner scanner = new Scanner(System.in);
	System.out.println("\n -Ønsker du å lagre data til fil først? \n" +
			   "-Tast '1' for ja, tast hvilken som helst annen tast for nei.");
	System.out.print("> ");
	int svar0;
	try {
	    svar0 = scanner.nextInt();
	} catch (InputMismatchException e) {
	    svar0 = 0;
	}
	
	//hvis data skal lagres, bes bruker om filnavn, bruker standard lagringssted enn så lenge
	if (svar0 == 1) {
	    legesystem.skrivTilFil(lagringsSted); // svar5
	    System.out.println("Takk for nå.");
	    return 1;
	}
	else {
	    System.out.println("Takk for nå.");
	    return 1;
	}
    }

    // Konstruktør
    public Hovedmeny(Legesystem legesystem, String lagringsSted) {
	this.legesystem = legesystem;
	this.lagringsSted = lagringsSted;
	System.out.println(meny);
    }
    
    // HOVEDMENY
    public int hovedmeny() {
	int avslutt = 0;
	while (avslutt != 1){
	    try {
		int svar;
		System.out.println("Legesystem. Tast 0 for hjelp.");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tast inn ditt valg, avslutt med enter:");
		System.out.print("> ");
		svar = scanner.nextInt();
		
		//switch med svar som paramenter. Seks ulike caser.
		switch(svar)
		    {
			//for å vise meny
		    case 0:
			System.out.println(meny);
			break;
			//skriver ut info om alle elementer i systemet
		    case 1:
			skrivListe();
			break;
			//metoder for å opprette og legge til elementer
		    case 2:
			leggeTilElementer();
			break;
			
			//bruke resept
		    case 3:
			brukResept();
			break;
			//skrive ut statistikk
		    case 4:
			legesystem.visStatistikk();
			break;
			//skrive all data til fil
		    case 5:
			legesystem.skrivTilFil(lagringsSted);
			break;
			//avslutte programmet
		    case 6:
			avslutt = avslutt();
			break;
			//hvis ingen av casene slår inn:
		    default:
			System.out.println("Du har tastet inn et menyvalg som ikke er gyldig.");
		    }
	    }
	    catch (InputMismatchException e) {
		System.out.println(meny);
		avslutt = hovedmeny();
	    }
	} // switch
	return 1;
    }
}
