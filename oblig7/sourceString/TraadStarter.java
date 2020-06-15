/**
   TraadStarter er en klasse som har ansvaret for å starte nye tråder. Rute klassene
   fortsetter å ha ansvaret for å gå osv., men TraadStarter holder rede på hvordan 
   trådene skal startes og hva som skal skje når de avsluttes (her med join metoden).
   Dermed holdes run metoden osv. unna Rutene
**/

class TraadStarter implements Runnable {
    // Maa ha peker til nåværende snøret 'PathMonitor'
    PathMonitor pathMonitor;
    // Peker til den naaværende ruten
    Rute rute;

    // Konstruktør
    public TraadStarter(Rute rute, PathMonitor pathMonitor) {
	this.rute = rute;
	this.pathMonitor = pathMonitor;
    }

    // En metode for å starte ny tråd
    public void startNyTraad() throws InterruptedException {
	Thread traad = new Thread(this);
	traad.start();
	traad.join();
    }

    
    // run() kjører bare gaa til designert rute
    // Leverer videre ansvar tilbake til Rute klassene
    public void run() {
	rute.gaa(pathMonitor);
    }
}
