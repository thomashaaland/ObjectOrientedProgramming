class TestForm {
    public static void main(String[] args) {
	// tester kvadratbeholder først
	KvadratBeholder kb = new KvadratBeholder();
	kb.settInn(new Kvadrat(2));

	System.out.println("Areal på objekt holdt av Kvadratbeholder: "
			   + kb.taUt().area() + ". Forventer 4.");

	// tester beholder
	Beholder<Sirkel> b1 = new Beholder<>();
	b1.settInn(new Sirkel(3));

	System.out.println("Areal på Sirkel: " + b1.taUt().area()
			   + ". Forventer " + 3*3*3.14 + ".");

	Beholder<Kvadrat> kb2 = new Beholder<>();
	kb2.settInn(new Kvadrat(2));

	System.out.println("Areal på objekt holdt av Beholder<Kvadrat>: "
			   + kb.taUt().area() + ". Forventer 4.");


	// Forventer feilmelding
	// kb2.settInn(new Sirkel(3));
    }
    
}
