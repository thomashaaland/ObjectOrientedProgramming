import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NteTall {
    Condition ikkeNeste;
    Condition provIgjen;
    Lock tallLaas;
    
    private final int END = 10000;
    private final int N = 10;
    
    public NteTall() {
	tallLaas = new ReentrantLock();
	ikkeNeste = tallLaas.newCondition();
	provIgjen = tallLaas.newCondition();
	System.out.println("Starting");
	Monitor monitor = new Monitor(tallLaas, ikkeNeste);
	
	for (int i = 0; i < 10; i++) {
	    new Thread(new RunCount(i, END, N, monitor)).start();
	}
    }
    
    public static void main(String[] args) {
	System.out.println("Beginning");
	new NteTall();
    }
}
    
