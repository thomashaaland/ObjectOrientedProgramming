/*
  --*java*--
  Terminal brukes for aa lese av hva spilleren gjor
  
  beOmKommando tar inn et spoersmaal og en serie valg.
  Sender tilbake valget som en int
  
  giStatus
*/

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

class Terminal implements Brukergrensesnitt {
    private Scanner sc;
    private ReentrantLock laas;
    // Konstruktor
    // param @ Scanner sc: henter inn et scanner objekt. 
    public Terminal(Scanner sc){
	this.sc = sc;
	laas = new ReentrantLock();
    }

    // beOmKommando jobber rekursivt dersom det gjoeres et valg som ikke eksisterer
    // er case insensitive
    // returnerer indeksen til valget.
    @Override
    public int beOmKommando(String spoersmaal, String[] alternativer) {
	laas.lock();
	try {
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
	finally {
	    laas.unlock();
	}
    }

    // Gir status
    @Override
    public void giStatus(String status) {
	laas.lock();
	try {
	    System.out.println(status);
	}
	finally {
	    laas.unlock();
	}
    }

    public void laas() {
	laas.lock();
    }

    public void laasopp() {
	laas.unlock();
    }
}
