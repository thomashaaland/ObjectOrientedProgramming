class SortRute extends Rute {
    public SortRute(int kolonne, int rad, Labyrint labyrint) {
	super(kolonne, rad, labyrint);
    }

    @Override
    protected boolean erHvit() {
	return false;
    }

    @Override
    protected boolean erAapning() {
	return false;
    }
    
    @Override
    protected char tilTegn() {
	return '#';
    }
}
