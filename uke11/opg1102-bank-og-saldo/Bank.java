import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank {
    private int saldo;
    Lock laas = new ReentrantLock();
    
    public Bank() {
	saldo = 0;
    }

    public Bank(int sum) {
	saldo = sum;
    }

    public void ta(int sum) {
	laas.lock();
	try {
	    saldo = saldo - sum;
	}
	finally {
	    laas.unlock();
	}
    }

    public void gi(int sum) {
	laas.lock();
	try {
	    saldo = saldo + sum;
	}
	finally {
	    laas.unlock();
	}
    }

    public int saldo() {
	return saldo;
    }
}
