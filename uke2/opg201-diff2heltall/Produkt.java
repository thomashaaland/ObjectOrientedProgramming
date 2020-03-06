import java.util.Scanner;
/** 
    Dette programmet tar inn to tall, x og y og beregner produktet
    Programmet sjekker også om x er større enn y og skriver ut om 
    differansen er positiv, null eller negativ.
*/

class Produkt {
    public static void main(String[] args) {
	// Erklærer variabler
	int x;
	int y;
	// Oppretter Scanner for å lese inn bruker input
	Scanner in;
	System.out.print("Oppgi verdien til x: ");
	in = new Scanner(System.in);
	x = in.nextInt();
        
	System.out.print("Oppgi verdien til y: ");
	in = new Scanner(System.in);
	y = in.nextInt();

	// Skkriver ut produktet av x og y
	System.out.print("Produktet av x og y er ");
	System.out.print(x * y);
	System.out.println(".");
	System.out.print("Absoluttverdien er: ");
	System.out.println(Math.abs(x * y));

	// Forklarer om differansen er positiv, negativ eller null
	if (x - y > 0) {
	    System.out.println("Differansen mellom x og y er positiv.");
	}
	else if (x - y < 0) {
	    System.out.println("Differansen mellom x og y er negativ.");
	}
	else {
	    System.out.println("x er lik y og differansen er 0.");
	}
	    
    }
}
