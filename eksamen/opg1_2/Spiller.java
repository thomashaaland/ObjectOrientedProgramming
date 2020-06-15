/*
  --*java*--
  Klasse som simulerer spilleren
*/

import java.util.ArrayList;
import java.util.Random;

class Spiller {
    private int formue;
    private Sted sted;
    private Brukergrensesnitt bgs;
    private Skattkiste ryggsekk;
    
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
	// 1. skal du selge en gjenstand?
	int selge = 1;
	if (!ryggsekk.erTom()) {
	    selge = bgs.beOmKommando("Skal du selge en gjenstand?", new String[]{"Ja", "Nei"});
	}
	else {
	    bgs.giStatus("Ryggsekken din er tom.");
	}
	// 2. oppdater formue
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
	// 3. dersom det er mer plass i sekken, vil du plukke opp ny gjenstand?
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
	// 4. velg utgang og gå til nytt sted
        bgs.giStatus("Det aapner seg en magisk portal foran deg og du gaar gjennom den.");
	sted = sted.gaaVidere();
	return sted;
    }
    
    public int oppgiFormue() {
	return formue;
    }
}
