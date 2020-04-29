class Hovedprogram {
    public static void main(String[] args) {
	int nThreads = 10;
	Bank bank = new Bank();
	
	for (int i = 0; i < nThreads; i++) {
	    Thread t = new Thread(new GiOgTa(bank, i));
	    t.start();
	}
    }
}
