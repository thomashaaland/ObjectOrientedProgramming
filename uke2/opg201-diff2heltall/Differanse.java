import java.util.Scanner;
import java.lang.Math;
/** 
    Dette programmet beregner differansen mellom x og y
*/

class Differanse {
    public static void main(String[] args) {
	// oppretter variable
	int x;
	int y;
	// oppretter Scanner for å lese inn bruker input
	Scanner in;
	System.out.print("Oppgi verdien til x: ");
	in = new Scanner(System.in);
	x = in.nextInt();
        
	System.out.print("Oppgi verdien til y: ");
	in = new Scanner(System.in);
	y = in.nextInt();

	// Skriver ut differansen og absolutt verdien av differansen
	System.out.print("Differansen mellom x og y er ");
	System.out.print(x - y);
	System.out.println(".");
	System.out.print("Absoluttverdien er: ");
	System.out.println(Math.abs(x - y));
    }
}
