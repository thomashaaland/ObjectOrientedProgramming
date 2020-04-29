class Oppover implements Runnable {
    private Tallmonitor monitor;
    private int tall;
    private boolean minStorreEnnMinst = true;

    public Oppover(Tallmonitor monitor) {
	this.monitor = monitor;
	tall = Integer.MIN_VALUE;
    }

    public void run() {
	while(monitor.settMinste(tall)) {
	    tall++;
	}
	System.out.println("STOPP! Tallet er ikke lenger minst: " + tall);
    }
}
