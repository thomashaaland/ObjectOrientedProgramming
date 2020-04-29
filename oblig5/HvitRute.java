class HvitRute extends Rute {
    public boolean hvit = true;
    
    public HvitRute(int kolonne, int rad, Labyrint labyrint) {
	super(kolonne, rad, labyrint);
    }
    
    @Override
    protected boolean erHvit() {
	return true;
    }

    @Override
    protected boolean erAapning() {
	return false;
    }

    @Override
    protected char tilTegn() {
	return ' ';
    }
}
