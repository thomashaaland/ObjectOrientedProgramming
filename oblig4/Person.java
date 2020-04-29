class Person {
    protected String navn;

    public Person(String navn) {
	this.navn = navn;
    }

    public String hentNavn() {
	return navn;
    }

    public String toString() {
	return "Person: " + navn;
    }
}
