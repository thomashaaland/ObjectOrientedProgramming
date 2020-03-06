class Person {
    private String navn;
    private String gjenstand;
    private Person neste;

    public Person(String navn, String gjenstand) {
	this.navn = navn;
	this.gjenstand = gjenstand;
	neste = null;
    }

    public void settNeste(Person person) {
	neste = person;
    }

    public Person hentNeste() {
	return this.neste;
    }

    public String hentNavn() {
	return navn;
    }

    public String hentGjenstand() {
	return gjenstand;
    }

    @Override
    public String toString() {
	return navn + " kjøper " + gjenstand + ".";
    }
}
