import java.util.Scanner;
import java.util.ArrayList;

class Testprogram {
    public static void main(String[] args) {

	Scanner inPut = new Scanner(System.in);
	int uInput;
	
	ArrayList<Bil> regList = new ArrayList<Bil>();
	
	System.out.println("Velkommen til bilTema testprogram");
	
	while (true) {
	    System.out.println("Valgmuligheter: ");
	    System.out.println("1: Registrer nytt kjøretøy.");
	    System.out.println("2: Skriv ut Info på biler.");
	    System.out.println("3: Avslutt");
	    System.out.print(">: ");

	    uInput = inPut.nextInt();
	    
	    if (uInput == 1) {
		regList.add(new Varebil("123", "Jens", "Sted", 20));
	    }
	    else if (uInput == 2) {
		for (Bil bil : regList) {
		    bil.skrivInfo();
		}
	    }
	    else if (uInput == 3) {
		break;
	    }
	    inPut.nextLine();
	}
	
    }
}
