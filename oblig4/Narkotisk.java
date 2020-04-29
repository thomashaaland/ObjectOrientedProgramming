/*
  Narkotisk arver Legemiddel. I tillegg til Legemiddels funksjonalitet skal
  Narkotisk lagre narkotiskStyrke.
*/
public class Narkotisk extends Legemiddel {
    protected int styrke;
    // Konstruktør, sender navn, pris og virkestoff videre til Legemiddel
    public Narkotisk(String navn, double pris, double virkestoff, int styrken) {
	super(navn, pris, virkestoff);
	styrke = styrken;
    }

    // Returnerer variabelen int styrke.
    public int hentNarkotiskStyrke() {
	return styrke;
    }

    // toString override
    @Override
    public String toString() {
	return String.format("Narkotisk %74s    - Narkotisk styrke: %4s", super.toString(), hentNarkotiskStyrke());
    }           
}
