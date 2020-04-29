/**
   HvitRute må kunne vite at naborutene er hvite og om denne stien er gått før
   Dersom man kan gå flere retninger startes en ny tråd for hver retning unntatt
   den siste mulige retningen. Selve trådstartingen gjøres med TraadStarter klassen
   slik at HvitRute får mindre ansvar. 
 **/
class HvitRute extends Rute {
    public boolean hvit = true;
    
    public HvitRute(int kolonne, int rad, Labyrint labyrint) {
	super(kolonne, rad, labyrint);
    }

    @Override
    protected String koordinater() {
	return "(" + kolonne + ", " + rad + ")-->";
    }

    
    @Override
    public void gaa(PathMonitor pathMonitor) {
	// Starter hele prossessen med å legge ut snøret i nåværende rute
	pathMonitor.oppdater(this);
	
	// Finner ut hvor mange retninger man kan gå,
	// dersom antall retninger man kan gå er flere enn 1
	// skal det startes nye tråder med ny sti
	// for alle ruter bortsett fra den siste
	
	// Først prøv å opprett nye threads:
	// Deretter fortsett gamle tråden
	int muligeStier = 4;
	for (Rute retning : retninger()) {
	    if (!pathMonitor.vaertHerFoer(retning)) {
		if (muligeStier > 1) {
		    try {
		        new TraadStarter(retning, new PathMonitor(pathMonitor)).startNyTraad();
			muligeStier--;
		    }
		    catch (InterruptedException e) {
			System.out.println(e);
		    }
		}
		// Her fortsettes den gamle tråden. Endrer kun den nåværende ruten
		else {
		    retning.gaa(pathMonitor);
		}
	    }
	}
    }

    @Override
    protected char tilTegn() {
	return ' ';
    }
}
