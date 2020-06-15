/*
  --*java*--
  Gjenstand har noen verdier. Disse settes naar gjenstanden blir
  opprettet.
*/

class Gjenstand {
    // verdier skal leses inn fra filen <<gjenstander.txt>>
    int verdi;
    String navn;
    
    public Gjenstand(String navn, int verdi) {
	this.verdi = verdi;
	this.navn = navn;
    }

    public String navn() {
	return navn;
    }
    
    public int verdi() {
	return verdi;
    }

    @Override
    public String toString() {
	return navn + " verd " + verdi;
    }
    
}
