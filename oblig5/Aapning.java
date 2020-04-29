class Aapning extends HvitRute {
    public boolean aapning = true;
    
    public Aapning(int kolonne, int rad, Labyrint labyrint) {
	super(kolonne, rad, labyrint);
    }

    @Override
    protected boolean erAapning() {
	return true;
    }

    @Override
    protected char tilTegn() {
	return ' ';
    }
}
