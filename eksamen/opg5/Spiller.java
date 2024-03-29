/*
  --*java*--
  Klasse som simulerer spilleren
*/

import java.util.ArrayList;
import java.util.Random;

class Spiller {
    protected int formue;
    protected Sted sted;
    protected Brukergrensesnitt bgs;
    protected Skattkiste ryggsekk;
    
    // Konstruktor
    public Spiller(Sted startSted, Brukergrensesnitt brukergrensesnitt) {
	sted = startSted;
        bgs = brukergrensesnitt;
	ryggsekk = new Skattkiste(3, "Spiller");
    }

    // Her gjores alle handlingene til spilleren
    public Sted nyttTrekk() {
	String status = "Du er kommet til et nytt sted og du ser rundt deg.\n" + sted +
	    "\nDet staar en magisk kiste og skinner med et blaatt lys like ved.\n" +
	    "Hva gjoer du?";
	bgs.giStatus(status);

	// 2 og 1. selg og oppdater formue
	oppdaterFormue(selge());

	// 3. dersom det er mer plass i sekken, vil du plukke opp ny gjenstand?
	plukkeOppGjenstand();

	// 4. velg utgang og gå til nytt sted
	return gaaVidere();
    }

    // Metode for aa oppgi formue
    public int oppgiFormue() {
	return formue;
    }

    // Hjelpemetode for aa finne ut om spiller vil selge
    private int selge() {	
	int selge = 1;
	if (!ryggsekk.erTom()) {
	    selge = bgs.beOmKommando("Skal du selge en gjenstand?", new String[]{"Ja", "Nei"});
	}
	else {
	    bgs.giStatus("Ryggsekken din er tom.");
	}
	return selge;
    }

    // Hjelpemetode for aa se hva som skjer naar spiller selger
    private void oppdaterFormue(int selge) {	
	if (selge == 0) {
	    if (!ryggsekk.erTom()) {
		if (sted.hentKiste().harPlass()) {
		    Gjenstand salgsGjenstand = ryggsekk.taUt();
		    int salgsverdi = sted.hentKiste().leggI(salgsGjenstand);
		    Random rand = new Random();
		    int usikkerhet = rand.nextInt(salgsverdi / 2) - salgsverdi / 4;
		    int salg = salgsverdi + usikkerhet;
		    formue += salg;
		    bgs.giStatus("Du selger en " + salgsGjenstand.navn() + " for "
			     + salg + ".");
		}
		else {
		    bgs.giStatus("Kisten er full og du faar ikke solgt!");
		}
	    } else {
	        bgs.giStatus("Du har ingen gjenstander aa selge!");
	    }
	}
	
    }

    // Hjelpemetode for aa kontrollere hva som skjer naar spiller plukker opp gjenstand
    private void plukkeOppGjenstand() {
	int plukkeOpp = bgs.beOmKommando("Vil du plukke opp en gjenstand fra skattekisten?", new String[]{"Ja", "Nei"});
	if (plukkeOpp == 0) {
	    if (!sted.hentKiste().erTom()) {
		if (ryggsekk.harPlass()) {
		    Gjenstand nyGjenstand = sted.hentKiste().taUt();
		    ryggsekk.leggI(nyGjenstand);
		    bgs.giStatus("Du plukket opp en " + nyGjenstand.navn() + " verdt " +
				 nyGjenstand.verdi() + ".");
		}
		else {
		    bgs.giStatus("Du har ikke plass i ryggsekken din.");
		}
	    }
	    else {
	        bgs.giStatus("Skattkisten var tom!");
	    }
	}
    }

    protected Sted gaaVidere() {
	bgs.giStatus("Det aapner seg en magisk portal foran deg og du gaar gjennom den.");
	sted = sted.gaaRettFrem();
	return sted;
    }
}
