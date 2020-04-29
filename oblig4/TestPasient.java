/**
   Tester funksjonalitet til Pasient klassen
   SKal kunne opprette pasient
   legge til og fjerne resepter.
   Skal kunne hente ut reseptlisten
**/
class TestPasient {
    public static void main(String[] args) {
	// Opretter pasient
	Pasient pasient = new Pasient("Hansen", "123");

	// Legger til to resepter til pasient
	pasient.nyResept(new Hvitresept(new Vanlig("Ibux", 200, 5), new Lege("Jensen"),
				    pasient, 3));
	pasient.nyResept(new Hvitresept(new Vanlig("Paracet", 100, 10), new Lege("Jensen"),
					pasient, 3));

	// Henter ut og skriver ut reseptlistern
	System.out.println("Skriver ut reseptliste: ");
	Iterator<Resept> iterator = pasient.hentReseptListe().iterator();
        while (iterator.hasNext()) {
	    System.out.println("- " + iterator.next());
	}

	// Tester fjernResept(). Skal fjerne resepten som er lagt til sist
	System.out.println("\nSkriver ut pasient: ");
	System.out.println(pasient);
	System.out.println("\nSkriver ut resept som blir fjernet: ");
	System.out.println(pasient.fjernResept());
    }
}
