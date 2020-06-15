/*
  --*java*--
  VeivalgSted utvider Sted klassen med muligheten til aa
  velge flere veivalg
*/

class VeivalgSted extends Sted {
    // Retninger tilgjengelig:
    // rettFrem
    // hoyre
    // venstre
    //protected Sted hoyre;
    //protected Sted venstre;
    protected Sted[] vei;
    
    // Konstruktor, sender beskrivelse videre til Sted
    public VeivalgSted(String beskrivelse) {
	super(beskrivelse);
	vei = new Sted[3];
    }

    @Override
    public void leggTilRettFrem(Sted rettFrem) {
	vei[0] = rettFrem;
    }
    
    public void leggTilHoyre(Sted hoyreVei) {
	//hoyre = hoyreVei;
	vei[1] = hoyreVei;
    }

    public void leggTilVenstre(Sted venstreVei) {
	//venstre = venstreVei;
	vei[2] = venstreVei;
    }

    public Sted[] gaa() {
	return vei;
    }

    @Override
    public Sted gaaRettFrem() {
	return vei[0];
    }
    
    public Sted gaaTilHoyre() {
	//return hoyre;
	return vei[1];
    }

    public Sted gaaTilVenstre() {
	//return venstre;
	return vei[2];
    }
}
