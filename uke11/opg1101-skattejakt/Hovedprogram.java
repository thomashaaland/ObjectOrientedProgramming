import java.io.*;
import java.util.Scanner;

class Hovedprogram {

    public static void main(String[] args) {
	Skattekart skattekart = null;

	try {
	    File fil = new File(args[0]);
	    skattekart = Skattekart.lesInn(fil);

	}
	catch (FileNotFoundException e) {
	    System.out.println("Fant ikke filen");
	}

	skattekart.skrivUt();
	Scanner brukerinput = new Scanner(System.in);

	System.out.println("\nFinn skatten! Gjett koordinatet på formatet (kol rad) (a for å avslutte);");
	String inn = brukerinput.nextLine();

	int antForsoek = 0;

	while (!inn.equals("a")) {
	    String[] l = inn.split(" ");

	    try {
		int kol = Integer.parseInt(l[0]);
		int rad = Integer.parseInt(l[1]);

		if (skattekart.sjekk(kol, rad)) {
		    System.out.println("\nDu fant skatten!");
		    inn = "a";

		}
		else {
		    antForsoek++;
		    System.out.println("\nIngen skatt der! Gjett igjen:");
		    inn = brukerinput.nextLine();
		}

		skattekart.skrivUt();

	    }
	    catch (NumberFormatException e) {
		System.out.println("UGYLDIGE KOORDINATER!");
	    }
	}
    }
}
