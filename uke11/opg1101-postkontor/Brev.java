class Brev extends Post {

    public Brev(String beskrivelse, String mottaker) {
	super(beskrivelse, mottaker);
    }

    public String toString() {
	return "Mottaker: " + mottaker + " - POST-Beskrivelse: " + beskrivelse;
    }
}
