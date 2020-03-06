/*
  Vanlig arver Legemiddel og har en konstruktør som sender alt
  direkte til Legemiddel konstruktøren. Vanlig har alle funksjonaliteter
  til Legemiddel og er ellers identisk.
*/

class Vanlig extends Legemiddel {
    // Konstruktør sender alt til superklassen Legemiddel
    public Vanlig(String navn, double pris, double virkestoff) {
	super(navn, pris, virkestoff);
    }

    // toString override
    @Override
    public String toString() {
	return "Vanlig       \t" + super.toString();
    }
}
