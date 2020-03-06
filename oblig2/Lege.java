/*
  Klasse for leger
*/
public class Lege {

    // Variabler
    protected String navn;

    // Konstruktør
    public Lege(String legensNavn) {
	navn = legensNavn;
    }

    // Getters
    public String hentNavn() {
	return navn;
    }

    public String toString() {
	return "Lege " + hentNavn();
    }
}
