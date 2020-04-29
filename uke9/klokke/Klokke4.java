import java.util.Scanner;

class Klokke4 {
    public static void main(String[] args) {
	System.out.println("Trykk <retur> for å starte og stoppe");
	Scanner tastatur = new Scanner(System.in);
	tastatur.nextLine();

	// Her lages et stoppeklokke objekt
	Stoppeklokke stoppeklokke = new Stoppeklokke();
	Thread mintrad = new Thread(stoppeklokke);

	// og her settes den nye traaden igang
	mintrad.start();

	tastatur.nextLine();
	mintrad.interrupt();
    }
}
