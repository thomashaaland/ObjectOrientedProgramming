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
	return "Lege spesialist " + hentNavn() + " med kontrollID " + hentKontrollID();
    }
    
}
