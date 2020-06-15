class StorNedbrytbarPappFlaskeMedPant extends Pappemballasje implements Pant, Nedbrytbar {
    int pant;
    String kode;
    int levetid;
    
    public StorNedbrytbarPappFlaskeMedPant(int volum, String prodID,
					   int vekt, int pant,
					   String kode, int levetid) {
	super(volum, prodID, vekt);
	this.pant = pant;
	this.kode = kode;
	this.levetid = levetid;
	System.out.println("Konstruktoren til klassen \"StorNedbrytbarPappFlaskeMedPant\" utfores");
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
