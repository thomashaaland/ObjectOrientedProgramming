class Post {
    String beskrivelse;
    String mottaker;

    public Post(String beskrivelse, String mottaker) {
	this.beskrivelse = beskrivelse;
	this.mottaker = mottaker;
    }

    public String hentBeskrivelse() {
	return beskrivelse;
    }

    public String hentMottaker() {
	return mottaker;
    }

    public String toString() {
	return "Mottaker: " + mottaker + " - Beskrivelse: " + beskrivelse;
    }
}
