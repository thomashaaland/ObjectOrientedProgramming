/*
  --*java*--
  SpillKontroll staar for oppsett og kaller selve spill klassen Spill
*/

import java.util.Scanner;
import java.util.ArrayList;

class SpillKontroll {
    public static void main(String[] args){
	/*
	Terminal spillerKonsoll = new Terminal(new Scanner(System.in));
	int valg = spillerKonsoll.beOmKommando("Velg:", new String[]{"En", "To", "Tre"}); 
	System.out.println("Du valgte " + valg);
	*/

	// 1. Opprett terreng
	Terreng terreng = new Terreng();
	// Sjekk om terreng funker
	/*
	Sted her = terreng.hentStart();
	while (her != null) {
	    System.out.println("Stedsbeskrivelse: " + her);
	    her = her.gaaVidere();
	}
	*/
	// 2. Opprett spiller
	Spiller spiller = new Spiller(terreng.hentStart(), new Terminal(new Scanner(System.in)));
	Spiller robot = new Spiller(terreng.hentStart(), new Robot());
	
	// 3. opprett og kjor Spill()
	Spill spill = new Spill(robot);
	spill.spill();
	// 4. Oppgi resultatet av spillingen ( navn og formue )
	System.out.println("Resultatet av spillet ble:\n" +
			   "Formue: " + spill.formueResultat());
    }
}
