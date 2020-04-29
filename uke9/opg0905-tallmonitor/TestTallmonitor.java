class TestTallmonitor {
    public static void main(String[] args) {
	Tallmonitor tm = new Tallmonitor();
	Thread t1 = new Thread(new Nedover(tm));
	Thread t2 = new Thread(new Oppover(tm));
	t1.start();
	t2.start();
    }
}
