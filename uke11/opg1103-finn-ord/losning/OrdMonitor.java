import java.util.concurrent.locks.*;

class OrdMonitor {

    int antall = 0;
    Lock laas = new ReentrantLock();

    public void fantOrdet() {
	laas.lock();
	try {
	    antall ++;
	}
	finally {
	    laas.unlock();
	}
    }

    public int hentAntall() {
	return antall;
    }
}
