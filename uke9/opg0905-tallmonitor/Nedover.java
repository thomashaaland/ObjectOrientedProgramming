class Nedover implements Runnable {
    private Tallmonitor monitor;
    private int tall;
    private boolean mindreEnnStorst = true;
    
    public Nedover(Tallmonitor monitor) {
	this.monitor = monitor;
	tall = Integer.MAX_VALUE;
    }

    public void run() {
	while(monitor.settStorste(tall)) {
	    tall--;
	}
	System.out.println("STOPP! Tallet er ikke lenger størst: " + tall);
    }
}
