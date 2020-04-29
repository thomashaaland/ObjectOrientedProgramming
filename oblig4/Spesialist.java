/**
   Spesialist arver fra Lege og implementerer grensesnittet fra
   Godkjenningsfritak
**/

public class Spesialist extends Lege implements Godkjenningsfritak {
    // Initier variabler
    protected int kontrollID;

    // Konstruktør
    public Spesialist(String navn, int kontrollIDen) {
	super(navn);
	kontrollID = kontrollIDen;
    }

    // Implementer funksjonalitet fra Godkjenningsfritak
    public int hentKontrollID() {
	return kontrollID;
    }

    public String toString() {
	return "Dr. " + hentNavn() + " med kontrollID " + hentKontrollID();
    }

    // Legger til en hvit resept
    @Override
    public Hvitresept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) {
	Hvitresept resept = new Hvitresept(legemiddel, this, pasient, reit);
	super.leggTilResept(resept);
	return resept;
    }

    // Legger til en militærresept
    @Override
    public Militaerresept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) {
	Militaerresept resept = new Militaerresept(legemiddel, this, pasient, reit);
	super.leggTilResept(resept);
	return resept;
    }

    // Legger til prevansjonsresept
    @Override
    public Presept skrivPResept(Legemiddel legemiddel, Pasient pasient) {
        Presept resept = new Presept(legemiddel, this, pasient);
	super.leggTilResept(resept);
	return resept;
    }

    // Legger til blåresept
    @Override
    public Blaaresept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) {
       	Blaaresept resept = new Blaaresept(legemiddel, this, pasient, reit);
	super.leggTilResept(resept);
	return resept;
    }
    
}
