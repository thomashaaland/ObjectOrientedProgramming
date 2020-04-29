import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Monitor {
    int tall = -1;
    Condition notNext;
    Lock lock;
    
    public Monitor(Lock laas, Condition ikkeNeste) {
	lock = laas;
	notNext = ikkeNeste;
    }
	
	
    public void skrivUt(int i) {
	lock.lock();
	try {
	    while (i - 1 != tall) {
		notNext.await();
	    }
	    tall = i;
	    System.out.println(tall);
	    notNext.signalAll();
	}
	catch(InterruptedException e) {
	    System.out.println("Error");
	}
	finally {
	    lock.unlock();
	}
    }
}
