/*
  Militærresept. Gir alltid 100% rabatt.
*/

public class Militaerresept extends Hvitresept {
    // Variable:
    // prisAabetale er alltid 0, siden det er 100% rabatt på
    // militærresept
    final static double prisAaBetale = 0;

    // Konstruktør
    public Militaerresept(Legemiddel legemiddel, Lege utskrivendeLege,
			  Pasient pasient, int reit) {
	super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public double prisAaBetale() {
	return prisAaBetale;
    }

    @Override
    public String toString() {
	return super.toString();
    }
}
