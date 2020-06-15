/*
  --*java*--
  Veialgspiller utvider Spiller klassen med muligheten for aa
  gaa i flere retninger
*/

class VeivalgSpiller extends Spiller {
    
    public VeivalgSpiller(VeivalgSted sted, Brukergrensesnitt bg) {
	super(sted, bg);
    }
    
    @Override
    protected Sted gaaVidere() {
	bgs.giStatus("Du ser det aapner seg tre magiske portaler. En til hoyre, en til venstre og en foran deg.");
	int vei = bgs.beOmKommando("Hvilken portal vil du gaa gjennom?", new String[]{"Rett fram", "Hoyre", "Venstre"});
	sted = ((VeivalgSted)sted).gaa()[vei];
	return sted;
    }
}
