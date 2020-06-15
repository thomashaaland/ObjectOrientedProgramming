/*
  --*java*--
  Terminal brukes for aa lese av hva spilleren gjor
  
  beOmKommando tar inn et spoersmaal og en serie valg.
  Sender tilbake valget som en int
  
  giStatus
*/

import java.util.Scanner;

class Terminal implements Brukergrensesnitt {
    Scanner sc;
    // Konstruktor
    // param @ Scanner sc: henter inn et scanner objekt. 
    public Terminal(Scanner sc){
	this.sc = sc;
    }

    // beOmKommando jobber rekursivt dersom det gjoeres et valg som ikke eksisterer
    // er case insensitive
    // returnerer indeksen til valget.
    @Override
    public int beOmKommando(String spoersmaal, String[] alternativer) {
	System.out.println(spoersmaal);
	for (String alternativ : alternativer) {
	    System.out.println(alternativ);
	}
	System.out.print("> ");
	int valg = -1;
	String input = sc.nextLine();
	for (int i = 0; i < alternativer.length; i++) {
	    if (input.toLowerCase().equals(alternativer[i].toLowerCase())) valg = i;
	}
	if (valg == -1) {
	    System.out.println("Du maa velge mellom valgene");
	    Terminal provIgjen = new Terminal(new Scanner(System.in));
	    valg = provIgjen.beOmKommando(spoersmaal, alternativer);
	}
	return valg;
    }

    // Gir status
    @Override
    public void giStatus(String status) {
	System.out.println(status);
    }
}
