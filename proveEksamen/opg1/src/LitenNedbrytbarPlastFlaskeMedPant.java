class LitenNedbrytbarPlastFlaskeMedPant extends Plastemballasje implements Nedbrytbar, Pant {
    int levetid;
    int pant;
    String kode;
    
    public LitenNedbrytbarPlastFlaskeMedPant(int volum, String prodID,
					     int levetid, String kode) {
	super(volum, prodID);
	this.levetid = levetid;
	pant = 100;
	this.kode = kode;
	
	System.out.println("Konstruktoren til klassen \"LitenNedbrytbarPlastFlaske\" utfores");
    }

    @Override
    public int oppgiPant() {
	return pant;
    }

    @Override
    public String oppgiKode() {
	return kode;
    }

    @Override
    public int oppgiLevetid() {
	return levetid;
    }
    
}
