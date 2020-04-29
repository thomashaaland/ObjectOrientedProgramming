import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Tallmonitor {
    private int detMinste;
    private int detStorste;
    private Lock laas = new ReentrantLock();

    public boolean settMinste(int nyMinste) {
	laas.lock();
	try {
	    if (detStorste <= nyMinste) return false;
	    detMinste = nyMinste;
	    return true;
	}
	finally {
	    laas.unlock();
	}
    }

    public boolean settStorste(int nyStorste) {
	laas.lock();
	try {
	    //System.out.println(detStorste + " " + detMinste);
	    if (nyStorste <= detMinste) return false;
	    detStorste = nyStorste;
	    return true;
	}
	finally {
	    laas.unlock();
	}
    }
}
