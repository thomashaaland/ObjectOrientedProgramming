/** 
    PathMonitor er en monitor som holder rede på hvor 
    trådene har vært og sørger for at trådene ikke går i veien for hverandre. 
    Metodene som trenger laas er metoder som kan endres mens de kjører: 
    PathMonitor(PathMonitor)
    vaertHerFoer()
    oppdater()
    tilbakesporing()
    Dersom disse ikke har laas kan de risikere å endre objekter som blir brukt til
    noe annet. Feks kan oppdater endre stabelen brukt i tilbakesporing slik at 
    tilbakesporing returnerer en stoerre stabel enn foerst tenkt.
    PathMonitor har dermed ansvaret for å holde rede på informasjonflyt 
    inn og ut av programmet
**/

import java.util.concurrent.locks.*;

class PathMonitor {

    Lock laas = new ReentrantLock();

    // tilbakesporing husker hvor en tråd har vært tidligere
    Stabel<Rute> tilbakesporing;
    // Peker til labyrinten
    Labyrint labyrint;
    
    // To konstruktører, den første for å holde rede
    // på den opprinnelige tråden fra main
    public PathMonitor(Labyrint labyrint) {
	tilbakesporing = new Stabel<>();
	this.labyrint = labyrint;
    }

    // Konstruktør som blir brukt ved korsvei. Bruker shallow copy
    // av PathMonitor til PathMonitor
    public PathMonitor(PathMonitor pathMonitor) {
	laas.lock();
	try {
	    tilbakesporing = new Stabel<>();
	    tilbakesporing.kopier(pathMonitor.tilbakesporing());
	    labyrint = pathMonitor.labyrint();
	}
	finally {
	    laas.unlock();
	}
    }
    
    // Metode for å sjekke om ruten man sjekker har blitt sjekket før
    public boolean vaertHerFoer(Rute naavaerendeRute) {
	laas.lock();
	try {
	    for (Rute rute : tilbakesporing) {
		if (rute.koordinater().equals(naavaerendeRute.koordinater())) {
		    return true;
		}
	    }
	    return false;
	}
	finally {
	    laas.unlock();
	}
    }
    
    // Metode som avslutter en path ved å legge til utveien i labyrinten
    public void fantUtvei() {
	labyrint.leggTilUtvei(tilbakesporing);
    }
    
    // Metode for å oppdatere PathMonitor med hvor vi har vært.
    public void oppdater(Rute rute) {
	laas.lock();
	try {
	    tilbakesporing.leggPaa(rute);
	}
	finally {
	    laas.unlock();
	}
    }

    // Metode som returnerer pekeren til labyrinten som er
    // lagret i PathMonitor
    public Labyrint labyrint() {
	return labyrint;
    }

    // Metode som returnerer tilbakesporingen
    public Stabel<Rute> tilbakesporing() {
	laas.lock();
	try {
	    return tilbakesporing;
	}
	finally {
	    laas.unlock();
	}
    }
}
