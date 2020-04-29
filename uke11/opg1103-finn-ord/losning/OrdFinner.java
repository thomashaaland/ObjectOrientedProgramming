import java.util.concurrent.CountDownLatch;

class OrdFinner implements Runnable {

    String[] listeMedOrd;
    String ordSomSkalFinnes;
    OrdMonitor monitor;
    CountDownLatch count;
    int startIndeks;
    int sluttIndeks;

    public OrdFinner(String[] listeMedOrd, int startIndeks, int sluttIndeks, String ordSomSkalFinnes, OrdMonitor monitor, CountDownLatch count) {
	this.listeMedOrd = listeMedOrd;
	this.ordSomSkalFinnes = ordSomSkalFinnes;
	this.monitor = monitor;
	this.count = count;
	this.startIndeks = startIndeks;
	this.sluttIndeks = sluttIndeks;
    }

    public void run() {
	for (int i = startIndeks; i < sluttIndeks; i++) {
	    if (listeMedOrd[i].equals(ordSomSkalFinnes)) {
		monitor.fantOrdet();
	    }
	}
	count.countDown();
    }
}
