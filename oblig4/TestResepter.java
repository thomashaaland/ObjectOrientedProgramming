class TestResepter {
    public static void main(String[] args) {
	// Opprett noen pasienter
	Pasient p1 = new Pasient("Jens Jensen", "123123");
	Pasient p2 = new Pasient("Astrid Oshaug", "321321");
	Pasient p3 = new Pasient("Knut Knudsen", "123321");
	Pasient p4 = new Pasient("Turid Turhaug", "321123");
	
	// Opprett noen legemidler
	Vanlig paracet = new Vanlig("Paracet", 109.99, 0.25);
	Narkotisk opium = new Narkotisk("Opium", 199.99, 0.95, 2);
	Vanlig ppille = new Vanlig("P-pille", 200, 0.47);

	// Opprett de fire forskjellige reseptene vi kan opprette.
	Hvitresept jensParacet = new Hvitresept(paracet, new Lege("Jensen"),
						p1, 2);
	Presept astridPpille = new Presept(ppille, new Lege("Lesteberg"),
					   p2);
	Militaerresept knudsenOpium = new Militaerresept(opium,
							 new Lege("Ingenmannsland"),
							 p3, 10);
	Blaaresept turidOpium = new Blaaresept(opium, new Lege("Torgeirsen"),
					       p4, 4);

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
