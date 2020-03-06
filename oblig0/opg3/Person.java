class Person {
    private Bil3 bil;

    public Person(Bil3 privatbil) {
	bil = privatbil;
    }

    public void skrivBilNummer() {
	System.out.println("Personens bilnummer er " + bil.hentNummer() + ".");
    }
}
