class Katt implements Comparable<Katt> {
    String navn;
    int alder;

    public Katt(String navnet, int alderen) {
	navn = navnet;
	alder = alderen;
    }

    @Override
    public String toString() {
	return "Katt med navn: " + navn + " og alder: " + alder;
    }

    public int compareTo(Katt andre) {
	if (this.alder > andre.alder) {
	    return -1;
	} else if (this.alder < andre.alder) {
	    return 1;
	} else {
	    return 0;
	}
    }
}
