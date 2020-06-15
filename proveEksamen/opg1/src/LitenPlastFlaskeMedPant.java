class LitenPlastFlaskeMedPant extends Plastemballasje implements Pant {
    int pant;
    String kode;
    
    public LitenPlastFlaskeMedPant(int volum, String prodID, String kode) {
	super(volum, prodID);
	pant = 100;
	this.kode = kode;
    }

    public int oppgiPant() {
	return pant;
    }

    public String oppgiKode() {
	return kode;
    }
}
