class Bokhylle {
    private Bok[] boeker;

    public Bokhylle (int antPlasser) {
	boeker = new Bok[antPlasser];
    }

    //Forsøker å sette inn en bok på første ledige plass i bokhylla
    public void settInn(Bok b) throws DuplikatException, IkkeMerPlassException {

	for (int i = 0; i < boeker.length; i++) {

	    // Boken ligger alt inne
	    if (boeker[i] != null && boeker[i].toString().equals(b.toString())) {
		throw new DuplikatException(b.toString());
	    }
	    
	    if (boeker[i] == null) {

		boeker[i] = b;
		return;
	    }
	}

	// Vi har kommet gjennom lista uten å finne ledig plass
	throw new IkkeMerPlassException(b.toString());
    }

    public void skrivBoeker() {
	for (Bok b: boeker) {
	    if (b != null) {
		System.out.println(b);
	    }
	}
    }
}
