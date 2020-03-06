class TestResepter {
    public static void main(String[] args) {

	// Opprett noen legemidler
	Vanlig paracet = new Vanlig("Paracet", 109.99, 0.25);
	Narkotisk opium = new Narkotisk("Opium", 199.99, 0.95, 2);
	Vanlig ppille = new Vanlig("P-pille", 200, 0.47);

	// Opprett de fire forskjellige reseptene vi kan opprette.
	Hvitresept jensParacet = new Hvitresept(paracet, new Lege("Jensen"),
						123, 2);
	Presept astridPpille = new Presept(ppille, new Lege("Lesteberg"),
					   124);
	Militaerresept knudsenOpium = new Militaerresept(opium,
							 new Lege("Ingenmannsland"),
							 125, 10);
	Blaaresept turidOpium = new Blaaresept(opium, new Lege("Torgeirsen"),
					       126, 4);

	System.out.println("Tester:");
	System.out.println(jensParacet.toString());
	System.out.println(astridPpille.toString());
	System.out.println(knudsenOpium.toString());
	System.out.println(turidOpium.toString());

	System.out.println("\nTester etter tre bruk:");
	jensParacet.bruk();
	jensParacet.bruk();
	jensParacet.bruk();
	astridPpille.bruk();
	astridPpille.bruk();
	astridPpille.bruk();
	knudsenOpium.bruk();
	knudsenOpium.bruk();
	knudsenOpium.bruk();
	turidOpium.bruk();
	turidOpium.bruk();
	turidOpium.bruk();
	
	System.out.println(jensParacet.toString());
	System.out.println(astridPpille.toString());
	System.out.println(knudsenOpium.toString());
	System.out.println(turidOpium.toString());

    }
}
