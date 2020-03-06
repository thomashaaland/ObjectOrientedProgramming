class Bachelorstudent extends Student {

    protected boolean tilgang;

    public Bachelorstudent(String navnet,
			   int alderen,
			   String kurset,
			   String laererstedet) {
	super(navnet, alderen, kurset, laererstedet);
    }

    public boolean harTilgang() {
	return false;
    }
    public void skrivInfo() {
	System.out.println("Bachelorstudent: " + navn + " -Alder: " + alder + "\nKurs: " + kurs +
			   " - lærersted: " + laerersted);
    }
}
