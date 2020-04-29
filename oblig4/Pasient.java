/**
   Klassen pasient arver fra Person. Har en unik ID som lages av 
   konstruktøren, en Stabel med resepter, personnr og navn.
   
   public nyResept() legger en ny resept på stabelen.
   public fjernResept() tar bort den øverste resepten på stabelen
   public hentReseptListe() returnerer stabelen av resepter
 **/

class Pasient extends Person {
    //Deklarasjoner
    static private int count = 0;
    private int id;
    private String persnum;
    private Stabel<Resept> reseptListe = new Stabel<Resept>();

    // Konstruktør
    public Pasient(String navn, String fodselsnummer) {
	super(navn);
	persnum = fodselsnummer;
	id = count++;
    }

    // Resept funksjonalitet
    // Legger en ny resept på reseptStabelen
    public void nyResept(Resept resept) {
	reseptListe.leggPaa(resept);
    }
    // Fjerner øverste resept
    public Resept fjernResept() {
	return reseptListe.taAv();
    }
    // Returnerer reseptliste
    public Stabel<Resept> hentReseptListe() {
	return reseptListe;
    }
    
    // Pasient funksjonalitet
    // Returnerer ID
    public int hentID() {
	return id;
    }
    // Returnerer personnummer
    public String hentPersnum() {
	return persnum;
    }
    // toString metoden
    @Override
    public String toString() {
	return String.format("Pasient: %-16s -personnummer: %-10s -pasientID: %s", hentNavn(), hentPersnum(), hentID());
    }
}
