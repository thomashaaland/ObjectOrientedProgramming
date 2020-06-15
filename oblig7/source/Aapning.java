/**
   Aapning avslutter en tråd med å oppdatere pathMonitor og kaller
   fantUtvei
 **/

class Aapning extends HvitRute {
    public boolean aapning = true;
    
    public Aapning(int kolonne, int rad, Labyrint labyrint) {
	super(kolonne, rad, labyrint);
    }

    @Override
    protected String koordinater() {
	return "(" + kolonne + ", " + rad + ")";
    }

    @Override
    public void gaa(PathMonitor pathMonitor) {
	// Starter hele prossessen med å legge ut snøret i nåværende rute
	pathMonitor.oppdater(this);
	pathMonitor.fantUtvei();
    }

    @Override
    protected char tilTegn() {
	return ' ';
    }
}
