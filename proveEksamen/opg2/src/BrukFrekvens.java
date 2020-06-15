import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class BrukFrekvens {
    public static void main(String[] args) {
	String filNavn = null;
	File fil = null;
	Scanner sc = null;
	Lenkeliste<String> tekster = new Lenkeliste<>();
	
	try {
	    filNavn = args[0];
	}
	catch (ArrayIndexOutOfBoundsException e){
	    System.out.println("Du maa oppgi fil");
	}

	try {
	    fil = new File(filNavn);
	    sc = new Scanner(fil);	
	}
	catch (FileNotFoundException e) {
	    System.out.println("Fant ikke filen " + filNavn);
	}

	int i = 0;
	while(sc.hasNext()) {
	    tekster.leggTil(sc.next());
	}
	
	Frekvens frek = new Frekvens(tekster);
	frek.finnFlest();
	System.out.println(frek.hentFlest());
	System.out.println(frek.hentAntall());
	
    }
}
