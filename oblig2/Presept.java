/** 
    Gir fast 108 kr avslag på prevensjonsmidler
**/

public class Presept extends Hvitresept {
    // Deklarer variabler

    // rabatt er fast
    private static final double avslag = 108;
    
    // pReit er antall legemiddler som kan fåes med Presept,
    // den er alltid 3
    private static final int pReit = 3;
    
    // Konstruktør
    public Presept(Legemiddel legemiddel, Lege utskrivendeLege,
		   int pasientId) {
	super(legemiddel, utskrivendeLege, pasientId, pReit);
    }

    // Prisen er minimalt 0, ellers lik pris - avslaget
    @Override
    public double prisAaBetale() {
	double sluttPris = legemiddel.hentPris() - avslag;
	return (sluttPris <= 0) ? 0 : sluttPris;
    }

    @Override
    public String toString() {
	return "Resept for prevensjon \t-" + super.toString();
    }
}
