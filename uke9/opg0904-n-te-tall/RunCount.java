import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RunCount implements Runnable {
    private final int START;
    private final int END;
    private final int N;
    private final Monitor MONITOR;

    private final Lock lock = new ReentrantLock();

    public RunCount(int start, int end, int n, Monitor monitor) {
	START = start;
	END = end;
	N = n;
	MONITOR = monitor;
    }

    public void run() {
	lock.lock();
	try {
	    for (int i = START; i < END; i++) {
		if (i % N - START == 0) {
		    MONITOR.skrivUt(i);
		}
	    }
	}
	finally {
	    lock.unlock();
	}
    }
}
