/*
  --*java*--
  SpillKontroll staar for oppsett og kaller selve spill klassen Spill
*/

import java.util.Scanner;
import java.util.ArrayList;

class SpillKontroll {
    public static void main(String[] args){
	// Sporr om hvor mange spillere
	int antSpillere = hentInteger("Hvor mange spillere skal spille?");
	int antBots = hentInteger("Hvor mange roboter?");
	
	// 1. Opprett terreng
	//Terreng terreng = new Terreng();
	VeivalgTerreng vTerreng = new VeivalgTerreng();

	// 2. Opprett spillere
	VeivalgSpiller[] spillere = opprettSpillere(vTerreng, antSpillere, antBots);
		
	// 3. opprett og kjor Spill()
	Spill spill = new Spill(spillere);
	spill.spill();
	// 4. Oppgi resultatet av spillingen ( navn og formue )
	System.out.println("\nSpillet er ferdig!\nResultatet av spillet ble:\n" +
			   "Formue:\n" + spill.formueResultat());
    }
    
    public static int hentInteger(String beskjed) {
	// inScanner for aa lese inn
	Scanner in = new Scanner(System.in);
	
    	System.out.println(beskjed);
	System.out.print("> ");
	int antSpillere = 0;
	try {
	    antSpillere = in.nextInt();
	}
	catch (Exception e) {
	    System.out.println("Du maa gi et heltallig antall.");
	    System.exit(0);
	}
	return antSpillere;
    }

    public static VeivalgSpiller[] opprettSpillere(VeivalgTerreng terreng, int antSpillere, int antBots) {
	VeivalgSpiller[] spillere = new VeivalgSpiller[antSpillere + antBots];
	// Legg til menneskelige spillere
	for (int i = 0; i < antSpillere; i++) {
	    spillere[i] = new VeivalgSpiller(terreng.hentStart(), new Terminal(new Scanner(System.in)));
	}
	// Legg til bots
	for (int j = 0; j < antBots; j++) {
	    spillere[antSpillere + j] = new VeivalgSpiller(terreng.hentStart(), new Robot());
	}
	return spillere;
    }
    
}
