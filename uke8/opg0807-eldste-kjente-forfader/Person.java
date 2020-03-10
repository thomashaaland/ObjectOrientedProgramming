class Person implements Comparable<Person> {
    private String navn;
    private int fodeaar;
    private Person mor;
    private Person far;

    public Person(int fodeaar, String navn, Person far, Person mor) {
	this.navn = navn;
	this.fodeaar = fodeaar;
	this.mor = mor;
	this.far = far;
    }

    public String hentNavn() {
	return navn;
    }

    public int hentFodeAar() {
	return fodeaar;
    }

    public Person hentMor() {
	return mor;
    }

    public Person hentFar() {
	return far;
    }
    
    @Override
    public String toString() {
	return "Navn: " + navn + ", født: " + fodeaar;
    }

    public int compareTo(Person annen) {
	if (fodeaar < annen.hentFodeAar()) {
	    return -1;
	} else if (fodeaar == annen.hentFodeAar()) {
	    return 0;
	} else {
	    return 1;
	}
    }

    public Person finnEldsteKjenteForfader() {
	if (far == null && mor == null) {
	    return this;
	} else if (far == null) {
	    return mor.finnEldsteKjenteForfader();
	} else if (mor == null) {
	    return far.finnEldsteKjenteForfader();
	} else if (far.compareTo(mor) < 0) {
	    return far.finnEldsteKjenteForfader();
	} else {
	    return mor.finnEldsteKjenteForfader();
	} 
    }
}
