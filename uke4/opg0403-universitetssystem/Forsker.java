class Forsker extends Ansatt {
    String fagomraade;

    public Forsker (String navnet,
		    int alderen,
		    int timelonnen,
		    String fagomraadet) {
	super(navnet, alderen, timelonnen);
	fagomraade = fagomraadet;
    }
    public void skrivInfo() {
	System.out.println("Forsker: " + navn + " -Alder: " + alder
			   + "\nFagområde: " + fagomraade);
    }
}
