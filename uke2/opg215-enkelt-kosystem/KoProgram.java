import java.util.Scanner;
class KoProgram {
    static public void main(String[] args) {
	boolean avslutt = true;
	KoSystem ko = new KoSystem();
	while(avslutt){
	    System.out.println("**MENY FOR BILLETTSYSTEM**");
	    System.out.println("1 - Trekk ny kolapp.");
	    System.out.println("2 - Betjen Kunde.");
	    System.out.println("3 . Print antall kunder i kø.");
	    System.out.println("4 - Avslutt.");
	    System.out.println("");
	    System.out.print("> ");

	    Scanner in = new Scanner(System.in);
	    int inPut = in.nextInt();
	    if (inPut == 1) {
		ko.trekkKoLapp();
	    }
	    else if (inPut == 2) {
		ko.betjentKunde();
	    }
	    else if (inPut == 3) {
		System.out.println("Det står " + ko.antKunder() + " personer i kø.");
	    }
	    if (inPut == 4) {
		avslutt = false;
	    }
	    
	}
    }
}
