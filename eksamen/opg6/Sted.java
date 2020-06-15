/*
  --*java*--
  Klassen sted har en beskrivelse av stedet,
  har mulighet for aa ha en skattkiste
  og har utganger som lenker til nabosteder
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.*;

public class Sted {
    // Beskrivelsen skal lastes fra filen <<steder.txt>>
    protected String beskrivelse;
    protected Skattkiste kiste;
    protected Sted rettFrem = null;

    //protected Condition opptatt;
    
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

    // Metode for aa gaa til rettFrem sted
    public Sted gaaRettFrem() {
	return rettFrem;
    }

    // Metode for aa legge til rettFrem sted
    public void leggTilRettFrem(Sted rettFrem) {
	this.rettFrem = rettFrem;
    }

    @Override
    public String toString() {
	return beskrivelse;
    }
}
