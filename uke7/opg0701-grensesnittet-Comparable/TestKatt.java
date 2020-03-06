class TestKatt {
    public static void main(String[] args) {
	Katt[] katteListe = new Katt[4];
	katteListe[0] = new Katt("Pus", 1);
	katteListe[1] = new Katt("Figaro", 20);
	katteListe[2] = new Katt("Pandora", 12);
	katteListe[3] = new Katt("Marrakesch", 11);

	Katt eldste = new Katt("Generisk", 0);
	for (Katt katt : katteListe) {
	    eldste = eldste.compareTo(katt) < 0 ? eldste : katt;
	}
	System.out.println(eldste.toString());
    }
}
