import java.util.Scanner;

/**
   Dette programmet tar inn input fra bruker og sjekker om det er større
   enn 10
*/

class MindreStorre {
    static int TI = 10;
    static int TYVE = 20;
    
    public static void main(String[] args) {
	int tall;
	Scanner lest;
	System.out.print("Skriv et tall: ");
	lest = new Scanner(System.in);

	tall = lest.nextInt();
	
	if (tall < TI) {
	    System.out.println("Tallet er under 10");
	}
	else if ((tall > TI) && (tall < TYVE)) {
	    System.out.println("Tallet er mellom 10 og 20");
	}
	else if (tall > TYVE) {
	    System.out.println("Tallet er større enn 20");
	}
	else if (tall == TI) {
	    System.out.println("Tallet er 10");
	}
	else if (tall == TYVE) {
	    System.out.println("Tallet er 20");
	}
	else {
	    System.out.println("Tallet er ikke på talllinja");
	}
	
    }
}
