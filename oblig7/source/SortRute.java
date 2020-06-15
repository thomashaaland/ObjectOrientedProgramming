/**
   SortRute, har ansvar for å være seg selv
**/

class SortRute extends Rute {
    public SortRute(int kolonne, int rad, Labyrint labyrint) {
	super(kolonne, rad, labyrint);
    }

    // Dersom gaa kalles i en sort rute skal ingenting skje
    @Override
    public void gaa(PathMonitor pathMonitor) {
	;
    }

    @Override
    protected String koordinater() {
	return "";
    }
    
    @Override
    protected boolean erHvit() {
	return false;
    }
    
    @Override
    protected char tilTegn() {
	return '#';
    }
}
