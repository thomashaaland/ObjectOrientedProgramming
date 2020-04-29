class GiOgTa implements Runnable {
    private Bank bank;
    static private int RUNFOR = 10;
    private int belop;
    
    public GiOgTa(Bank bank, int belop) {
	this.bank = bank;
	this.belop = belop;
    }

    public void run() {
	for (int i = 0; i < RUNFOR; i++) {
	    bank.ta(belop);
	    bank.gi(belop);
	    System.out.println(bank.saldo());
	}
    }
    
}
