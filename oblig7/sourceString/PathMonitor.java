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
    String tilbakesporing;
    // Peker til labyrinten
    Labyrint labyrint;
    
    // To konstruktører, den første for å holde rede
    // på den opprinnelige tråden fra main
    public PathMonitor(Labyrint labyrint) {
	tilbakesporing = "";
	this.labyrint = labyrint;
    }

    // Konstruktør som blir brukt ved korsvei. Bruker shallow copy
    // av PathMonitor til PathMonitor
    public PathMonitor(PathMonitor pathMonitor) {
	laas.lock();
	try {
	    tilbakesporing = pathMonitor.tilbakesporing();
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
	    String kord = naavaerendeRute.koord();
	    String pattern = ".*" + kord + ".*";
	    return tilbakesporing.matches(pattern);
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
	    tilbakesporing += rute.koordinater();
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
    public String tilbakesporing() {
	laas.lock();
	try {
	    return tilbakesporing;
	}
	finally {
	    laas.unlock();
	}
    }
}
