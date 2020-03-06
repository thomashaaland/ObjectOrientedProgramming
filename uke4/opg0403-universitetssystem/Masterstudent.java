class Masterstudent extends Student {

    public Masterstudent(String navnet,
		   int alderen,
		   String kurset,
		   String laererstedet) {
	super(navnet, alderen, kurset, laererstedet);
    }

    public boolean harTilgang() {
	return true;
    }

    public void skrivInfo() {
	System.out.println("Masterstudent: " + navn + " - Alder: "
			   + alder + "\nKurs: " + kurs + " - Lærersted: " + laerersted);
    }
}
