class Butikk {
    private Person forste;

    public Butikk() {
	forste = null;
   }

    public void entreButikk(Person p) {
	if (this.forste == null) {
	    this.forste = p;
	} else {
	    Person temp = forste;
	    while (temp.hentNeste() != null) {
		temp = temp.hentNeste();
	    }
	    temp.settNeste(p);
	}
    }

    public void kassa() {
	while (forste != null) {
	    System.out.println("Behandler kunde: " + forste);
	    forste = forste.hentNeste();
	}
	System.out.println("Tomt for kunder!");
    }
}
