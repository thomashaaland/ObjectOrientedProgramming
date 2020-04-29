class Stoppeklokke implements Runnable {
    public void run() {
	int tid = 0;
	try {
	    while (! Thread.interrupted()) {
		System.out.println(tid++);
		Thread.sleep(1000);
	    }
	}
	catch (InterruptedException e) {
	}
    }
}
