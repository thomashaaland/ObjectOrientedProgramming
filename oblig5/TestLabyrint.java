import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TestLabyrint {
    public static void main(String[] args) {
	String filnavn = null; // "./labyrinter/1.in";

	try {
	    filnavn = args[0];
	}
	catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("FEIL: For å bruke programmet: " +
			       "java TestLabyrint <filnavn>");
	    System.exit(1);
	}

	File fil = new File(filnavn);
	Labyrint labyrint = null;
	try {
	    labyrint = Labyrint.lesFraFil(fil);
	}
	catch (FileNotFoundException e) {
	    System.out.printf("FEIL: Kunne ikke lese filen '%s'\n", filnavn);
	    System.exit(1);
	}

	// For å skrive ut labyrinten
	System.out.println(labyrint);

	// Les start koordinater fra bruker
	Scanner inn = new Scanner(System.in);
	System.out.println("Skriv inn koordinater <kolonne> <rad> " +
			   "('a' for å avslutte)");
	String[] ord = inn.nextLine().split(" ");
	while (!ord[0].equals("a")) {
	    try {
		int startKol = Integer.parseInt(ord[0]);
		int startRad = Integer.parseInt(ord[1]);
		
		Liste<String> utveier = labyrint.finnUtveiFra(startKol, startRad);
		
		/*
		//Liste<String> utveier = l.finnUtveiFra(startKol, startRad);
		if (utveier.stoerrelse() != 0) {
		    while (utveier.stoerrelse() > 0) {
			System.out.println(utveier.taAv());
		    }
		} else {
		    System.out.println("Ingen utveier.");
		}
		*/
		System.out.println();
	    }
	    catch (NumberFormatException e) {
		System.out.println("Ugyldig input!");
	    }

	    System.out.println("Skriv inn nye koordinater " +
			       "('a' for å avslutte)");
	    ord = inn.nextLine().split(" ");
	}
    }
}
