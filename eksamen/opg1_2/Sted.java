/*
  --*java*--
  Klassen sted har en beskrivelse av stedet,
  har mulighet for aa ha en skattkiste
  og har utganger som lenker til nabosteder
 */

import java.util.ArrayList;
import java.util.Random;

public class Sted {
    // Beskrivelsen skal lastes fra filen <<steder.txt>>
    private String beskrivelse;
    private Skattkiste kiste;
    private Sted neste = null;
    
    // Konstruktor
    // param @ String beskrivelse beskriver stedet
    public Sted(String beskrivelse) {
	this.beskrivelse = beskrivelse;
    }

    // Metode for aa plassere ut kiste
    public void plasserSkattkiste() {
	Random rand = new Random();
	kiste = new Skattkiste(rand.nextInt(5));
    }

    // Metode for aa sende skattkiste til spiller
    public Skattkiste hentKiste() {
	return kiste;
    }

    // Metode for aa gaa til neste sted
    public Sted gaaVidere() {
	return neste;
    }

    // Metode for aa legge til neste sted
    public void leggTilSted(Sted neste) {
	this.neste = neste;
    }

    @Override
    public String toString() {
	return beskrivelse;
    }
}
