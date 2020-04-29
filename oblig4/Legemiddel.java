/*
  Legemiddel er en abstract class siden det alle virkelige legemidler tilhører
  en spesifik type. 
*/

abstract class Legemiddel {

    // Variabler opprettes. Count brukes for å telle alle gangene
    // Legemiddel opprettes (er static så blir sett felles for alle
    // objekter av typen Legemiddel), og id er et unikt tall for
    // alle objekter av typen Legemiddel.
    private static int count = 0;
    protected int id;
    protected String navn;
    protected double pris;
    protected double virkestoff;

    // Konstruktør
    Legemiddel(String navnet, double prisen, double virkestoffet) {
	navn = navnet;
	pris = prisen;
	virkestoff = virkestoffet;
	id = count++;
    }

    // Metoder
    // getters; returnerer variabler som klassen tar vare på
    public int hentID() {
	return id;
    }

    public String hentNavn() {
	return navn;
    }

    public double hentPris() {
	return pris;
    }

    public double hentVirkestoff() {
	return virkestoff;
    }

    // setters; setter variabler klassen tar vare på
    public void settNyPris(double nyPris) {
	pris = nyPris;
    }

    // Utskrifter
    @Override
    public String toString() {
	return String.format("ID: %-2s- Navn: %-20s- Pris: %-7s- Virkestoff: %-5s", hentID(), hentNavn(), hentPris(), hentVirkestoff());
    }
    
}
