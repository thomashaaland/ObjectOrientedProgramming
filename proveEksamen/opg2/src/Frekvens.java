class Frekvens {

    // Data struktur for parr
    private class Pair<T, K> {
	T first;
	K second;
	    
	public Pair(T first, K second) {
	    this.first = first;
	    this.second = second;
	}

	public void setFirst(T first) {
	    this.first = first;
	}

	public void setSecond(K second) {
	    this.second = second;
	}
	
	public T getFirst() {
	    return first;
	}

	public K getSecond() {
	    return second;
	}
    }
    
    int antall;
    Lenkeliste< Pair<String, Integer> > tekster = new Lenkeliste<>();
    String flestTekst;

    public Frekvens(Lenkeliste<String> tekster) {
	if (tekster.stoerrelse() <= 1000) {
	    for (String nyTekst : tekster) {
		boolean exists = false;
		for (Pair<String, Integer> pair : this.tekster) {
		    if (nyTekst.equals(pair.getFirst())) {
			pair.setSecond(pair.getSecond() + 1);
			exists = true;
		    }
		}
		if (! exists) {
		    this.tekster.leggTil(new Pair<String, Integer>(nyTekst, 1));
		}
	    }
	}
	else {
	    System.out.println("Kan lagre maks 1000 tekster");
	}
    }

    public void finnFlest() {
	antall = 0;
	for (Pair<String, Integer> pair : tekster) {
	    if ( pair.getSecond() > antall) {
		antall = pair.getSecond();
		flestTekst = pair.getFirst();
	    }
	}
    }
    
    public String hentFlest() {
	return flestTekst;
    }

    public int hentAntall() {
	return antall;
    }
}
