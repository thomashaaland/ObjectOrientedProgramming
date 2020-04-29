import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Monitor {
    int count;
    String word;
    Lock laas = new ReentrantLock();
    
    public Monitor(String word) {
	count = 0;
	this.word = word;
    }
    
    public void count() {
	laas.lock();
	try {
	    count += 1;
	}
	finally {
	    laas.unlock();
	}
    }

    public int getCount() {
	return count;
    }

    public String getWord() {
	return word;
    }
    
}
