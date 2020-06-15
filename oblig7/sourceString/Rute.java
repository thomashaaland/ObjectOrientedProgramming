/**
   klassen Rute har ansvar for å vite hva de selv er
   og skal vite om naboene sine. Bruker Polymorfi for
   gaa metoden og hver subklasse har implementert gaa
   forskjellig. Trenkte også metoder for å identifisere
   seg som hvit 
**/

abstract class Rute {
    // Koordinater: (kolonne, rad)
    protected int kolonne;
    protected int rad;
    protected Labyrint labyrint;
    protected Lenkeliste<Rute> retninger; // nord = 0, ost = 1, syd = 2, vest = 3;

    // Konstruktør
    public Rute(int kolonne, int rad, Labyrint labyrint) {
	this.kolonne = kolonne;
	this.rad = rad;
	this.labyrint = labyrint;
    }

    public void leggTilNaboer(Rute nord, Rute syd, Rute ost, Rute vest) {
	retninger = new Lenkeliste<>();
	retninger.leggTil(nord); retninger.leggTil(ost);
	retninger.leggTil(syd); retninger.leggTil(vest);
    }
	
    protected abstract String koordinater();

    // Created specifically for regex comparison Paranthesis needs to be included
    protected String koord() {
	return "\\(" + kolonne + ", " + rad + "\\)";
    }
    
    public void finnUtvei() {
	//RuteFlytt flytt = new RuteFlytt(this, new PathMonitor(labyrint) );
	//flytt.gaa(this);
	gaa(new PathMonitor(labyrint));
    }

    public Lenkeliste<Rute> retninger() {
	return retninger;
    }

    protected abstract void gaa(PathMonitor pathMonitor);
    
    protected abstract char tilTegn();
}
